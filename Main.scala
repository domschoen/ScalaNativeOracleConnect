import scala.scalanative.unsafe.{CInt, _}
import scala.scalanative.unsafe._, Nat._
import scala.scalanative.posix.sched.sched_param
import scala.scalanative.posix.time.timespec
import scala.scalanative.posix.sys.types._
import scalanative.unsigned._
import scala.scalanative.libc._
import stdlib._
import string._
import stdio._


object main {

  def main(args: Array[String]) {
    Zone { implicit z =>
        accessOracle(toCString(args(0)), toCString(args(1)), toCString(args(2)), toCString(args(3)))
    }
  }

  // DemoFetch.c
  def accessOracle(mainUserName: CString, mainPassword: CString, connectString: CString, sqlText: CString): Unit = {
    import odpic._

    var pool: Ptr[struct_dpiPool] = null
    val mainUserNameLength: CUnsignedInt = strlen(mainUserName).toUInt
    val mainPasswordLength: CUnsignedInt = strlen(mainPassword).toUInt
    val connectStringLength: CUnsignedInt = strlen(connectString).toUInt
    val dpi_MAJOR_VERSION = 3.toUInt
    val dpi_MINOR_VERSION = 4.toUInt

    val errorInfo = malloc(sizeof[struct_dpiErrorInfo]).asInstanceOf[Ptr[struct_dpiErrorInfo]]
    var gContext : Ptr[Ptr[struct_dpiContext]] = malloc(sizeof[Ptr[struct_dpiContext]]).asInstanceOf[Ptr[Ptr[struct_dpiContext]]];
    val contextCreation = dpiContext_create(dpi_MAJOR_VERSION, dpi_MINOR_VERSION, gContext, errorInfo)
    if (contextCreation < 0) {
      showError(!gContext, errorInfo)
    } else {
      var conn: Ptr[Ptr[dpiConn]] = malloc(sizeof[Ptr[dpiConn]]).asInstanceOf[Ptr[Ptr[dpiConn]]];

      val connectionCreation = dpiConn_create(!gContext, mainUserName,
        mainUserNameLength, mainPassword,
        mainPasswordLength, connectString,
        connectStringLength, null, null, conn)
      if (connectionCreation < 0) {
        showError(!gContext, errorInfo)
      } else {
        var rowidVar : Ptr[Ptr[dpiVar]] = malloc(sizeof[Ptr[dpiVar]]).asInstanceOf[Ptr[Ptr[dpiVar]]]
        var bindRowidValue : Ptr[Ptr[dpiData]] = malloc(sizeof[Ptr[dpiData]]).asInstanceOf[Ptr[Ptr[dpiData]]]
        // create variable for storing the rowid of one of the rows
        if (dpiConn_newVar(!conn, defines.DPI_ORACLE_TYPE_ROWID, defines.DPI_NATIVE_TYPE_ROWID, 1.toUInt,
          0.toUInt, 0.toUInt, 0, null, rowidVar, bindRowidValue) < 0)
          showError(!gContext, errorInfo)
        else {
          // prepare and execute statement
          var stmt : Ptr[Ptr[dpiStmt]] = malloc(sizeof[Ptr[dpiStmt]]).asInstanceOf[Ptr[Ptr[dpiStmt]]]

          if (dpiConn_prepareStmt(!conn, 0, sqlText, strlen(sqlText).toUInt, null, 0.toUInt, stmt) < 0)
            showError(!gContext, errorInfo)
          else {
            var numQueryColumns : Ptr[CUnsignedInt] = malloc(sizeof[dpiStmt]).asInstanceOf[Ptr[CUnsignedInt]]

            if (dpiStmt_execute(!stmt, 0.toUInt, numQueryColumns) < 0) {
              showError(!gContext, errorInfo)
            } else {
              // fetch rows
              var found : Ptr[CInt] = malloc(sizeof[CInt]).asInstanceOf[Ptr[CInt]]
              var bufferRowIndex : Ptr[CUnsignedInt] = malloc(sizeof[CUnsignedInt]).asInstanceOf[Ptr[CUnsignedInt]]
              var nativeTypeNum : Ptr[dpiNativeTypeNum] = malloc(sizeof[dpiNativeTypeNum]).asInstanceOf[Ptr[dpiNativeTypeNum]]
              var firstNameColValue : Ptr[Ptr[dpiDataDpiBytes]] = malloc(sizeof[Ptr[dpiDataDpiBytes]]).asInstanceOf[Ptr[Ptr[dpiDataDpiBytes]]]
              var lastNameColValue : Ptr[Ptr[dpiDataDpiBytes]] = malloc(sizeof[Ptr[dpiDataDpiBytes]]).asInstanceOf[Ptr[Ptr[dpiDataDpiBytes]]]
              var rowidValue : Ptr[Ptr[dpiData]] = malloc(sizeof[Ptr[dpiData]]).asInstanceOf[Ptr[Ptr[dpiData]]]
              var continueFetching = true
              var rowidAsString : Ptr[CString] = malloc(sizeof[CString]).asInstanceOf[Ptr[CString]]

              var rowidAsStringLength : Ptr[CUnsignedInt] = malloc(sizeof[CUnsignedInt]).asInstanceOf[Ptr[CUnsignedInt]]
              var count = 0
              while (continueFetching) {
                if (dpiStmt_fetch(!stmt, found, bufferRowIndex) < 0) {
                  showError(!gContext, errorInfo)
                  continueFetching = false;
                } else {
                  continueFetching = !found == 1
                  if (continueFetching) {
                    count = count +1

                    if (dpiStmt_getQueryValue(!stmt, 1.toUInt, nativeTypeNum, firstNameColValue.asInstanceOf[Ptr[Ptr[dpiData]]]) < 0 ||
                      dpiStmt_getQueryValue(!stmt, 2.toUInt, nativeTypeNum, lastNameColValue.asInstanceOf[Ptr[Ptr[dpiData]]]) < 0)
                      {
                        showError(!gContext, errorInfo)
                        continueFetching = false;
                      } else {
                      stdio.printf(c"First name = '%.*s', Last name = '%.*s'\n",
                          (!firstNameColValue)._2._2,  // .asBytes.length
                          (!firstNameColValue)._2._1, // .asBytes.ptr,
                          (!lastNameColValue)._2._2,
                          (!lastNameColValue)._2._1
                        );
                     }
                  }
                }
              }
              println("Found " + count + " records")
            }
          }
        }
      }
    }

    def showError(context: Ptr[struct_dpiContext], errorInfo: Ptr[struct_dpiErrorInfo]): Unit = {
      dpiContext_getError(context, errorInfo)
      stdio.printf(c"ERROR: %.*s (%s : %s)\n",
        errorInfo._4,           // messageLength,
        errorInfo._3,  // message
        errorInfo._6,  // fnName
        errorInfo._7)  //action
    }
  }

}