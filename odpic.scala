import scala.scalanative.posix.sys.types.pthread_mutex_t
import scala.scalanative.unsafe.Nat.{Digit3, Digit4, _0, _1, _2, _3, _4, _7}
import scala.scalanative.unsafe.{CArray, CChar, CFuncPtr2, CInt, CShort, CSignedChar, CSize, CString, CStruct10, CStruct11, CStruct12, CStruct17, CStruct2, CStruct20, CStruct21, CStruct22, CStruct3, CStruct4, CStruct5, CStruct6, CStruct7, CStruct8, CUnsignedChar, CUnsignedInt, CUnsignedLongLong, CUnsignedShort, Ptr, extern, link}
import scala.scalanative.unsafe._, Nat._
import scala.scalanative.posix.sched.sched_param
import scala.scalanative.posix.time.timespec
import scala.scalanative.posix.sys.types._
import scalanative.unsigned._
import scala.scalanative.libc._
import stdlib._
import string._
import stdio._

// Use of ODPI-C
@link("odpic")
@extern
object odpic {

  // uint8_t -> unsigned char -> unsafe.CUnsignedChar
  // uint16_t -> unsigned short -> unsafe.CUnsignedShort
  // uint32_t -> unsigned int -> unsafe.CUnsignedInt
  // uint64_t -> unsigned long long -> unsafe.CUnsignedLongLong
  // unsigned -> unsigned int -> unsafe.CUnsignedInt

  // int8_t ->  signed char  -> CSignedChar
  // int16_t -> signed short -> CShort
  // int32_t -> signed int    -> CInt

  object defines {
    val DPI_MAJOR_VERSION: CInt = 3
    val DPI_MINOR_VERSION: CInt = 4
    val DPI_PATCH_LEVEL: CInt = 0
    val DPI_VERSION_SUFFIX: CString = c"-dev"
    val DPI_DEFAULT_FETCH_ARRAY_SIZE: CInt = 100
    val DPI_DEFAULT_PING_INTERVAL: CInt = 60
    val DPI_DEFAULT_PING_TIMEOUT: CInt = 5000
    val DPI_DEQ_WAIT_NO_WAIT: CInt = 0
    val DPI_MAX_INT64_PRECISION: CInt = 18
    val DPI_SUCCESS: CInt = 0
    val DPI_FAILURE: CInt = -1
    val DPI_DEBUG_LEVEL_FREES: CInt = 1
    val DPI_DEBUG_LEVEL_REFS: CInt = 2
    val DPI_DEBUG_LEVEL_FNS: CInt = 4
    val DPI_DEBUG_LEVEL_ERRORS: CInt = 8
    val DPI_DEBUG_LEVEL_SQL: CInt = 16
    val DPI_DEBUG_LEVEL_MEM: CInt = 32
    val DPI_MODE_AUTH_DEFAULT: CInt = 0
    val DPI_MODE_AUTH_SYSDBA: CInt = 2
    val DPI_MODE_AUTH_SYSOPER: CInt = 4
    val DPI_MODE_AUTH_PRELIM: CInt = 8
    val DPI_MODE_AUTH_SYSASM: CInt = 32768
    val DPI_MODE_AUTH_SYSBKP: CInt = 131072
    val DPI_MODE_AUTH_SYSDGD: CInt = 262144
    val DPI_MODE_AUTH_SYSKMT: CInt = 524288
    val DPI_MODE_AUTH_SYSRAC: CInt = 1048576
    val DPI_MODE_CONN_CLOSE_DEFAULT: CInt = 0
    val DPI_MODE_CONN_CLOSE_DROP: CInt = 1
    val DPI_MODE_CONN_CLOSE_RETAG: CInt = 2
    val DPI_MODE_CREATE_DEFAULT: CInt = 0
    val DPI_MODE_CREATE_THREADED: CInt = 1
    val DPI_MODE_CREATE_EVENTS: CInt = 4
    val DPI_MODE_DEQ_BROWSE: CInt = 1
    val DPI_MODE_DEQ_LOCKED: CInt = 2
    val DPI_MODE_DEQ_REMOVE: CInt = 3
    val DPI_MODE_DEQ_REMOVE_NO_DATA: CInt = 4
    val DPI_DEQ_NAV_FIRST_MSG: CInt = 1
    val DPI_DEQ_NAV_NEXT_TRANSACTION: CInt = 2
    val DPI_DEQ_NAV_NEXT_MSG: CInt = 3
    val DPI_EVENT_NONE: CInt = 0
    val DPI_EVENT_STARTUP: CInt = 1
    val DPI_EVENT_SHUTDOWN: CInt = 2
    val DPI_EVENT_SHUTDOWN_ANY: CInt = 3
    val DPI_EVENT_DEREG: CInt = 5
    val DPI_EVENT_OBJCHANGE: CInt = 6
    val DPI_EVENT_QUERYCHANGE: CInt = 7
    val DPI_EVENT_AQ: CInt = 100
    val DPI_MODE_EXEC_DEFAULT: CInt = 0
    val DPI_MODE_EXEC_DESCRIBE_ONLY: CInt = 16
    val DPI_MODE_EXEC_COMMIT_ON_SUCCESS: CInt = 32
    val DPI_MODE_EXEC_BATCH_ERRORS: CInt = 128
    val DPI_MODE_EXEC_PARSE_ONLY: CInt = 256
    val DPI_MODE_EXEC_ARRAY_DML_ROWCOUNTS: CInt = 1048576
    val DPI_MODE_FETCH_NEXT: CInt = 2
    val DPI_MODE_FETCH_FIRST: CInt = 4
    val DPI_MODE_FETCH_LAST: CInt = 8
    val DPI_MODE_FETCH_PRIOR: CInt = 16
    val DPI_MODE_FETCH_ABSOLUTE: CInt = 32
    val DPI_MODE_FETCH_RELATIVE: CInt = 64
    val DPI_MODE_MSG_PERSISTENT: CInt = 1
    val DPI_MODE_MSG_BUFFERED: CInt = 2
    val DPI_MODE_MSG_PERSISTENT_OR_BUFFERED: CInt = 3
    val DPI_MSG_STATE_READY: CInt = 0
    val DPI_MSG_STATE_WAITING: CInt = 1
    val DPI_MSG_STATE_PROCESSED: CInt = 2
    val DPI_MSG_STATE_EXPIRED: CInt = 3
    val DPI_NATIVE_TYPE_INT64: CInt = 3000
    val DPI_NATIVE_TYPE_UINT64: CInt = 3001
    val DPI_NATIVE_TYPE_FLOAT: CInt = 3002
    val DPI_NATIVE_TYPE_DOUBLE: CInt = 3003
    val DPI_NATIVE_TYPE_BYTES: CInt = 3004
    val DPI_NATIVE_TYPE_TIMESTAMP: CInt = 3005
    val DPI_NATIVE_TYPE_INTERVAL_DS: CInt = 3006
    val DPI_NATIVE_TYPE_INTERVAL_YM: CInt = 3007
    val DPI_NATIVE_TYPE_LOB: CInt = 3008
    val DPI_NATIVE_TYPE_OBJECT: CInt = 3009
    val DPI_NATIVE_TYPE_STMT: CInt = 3010
    val DPI_NATIVE_TYPE_BOOLEAN: CInt = 3011
    val DPI_NATIVE_TYPE_ROWID: CUnsignedInt = 3012.toUInt
    val DPI_OPCODE_ALL_OPS: CInt = 0
    val DPI_OPCODE_ALL_ROWS: CInt = 1
    val DPI_OPCODE_INSERT: CInt = 2
    val DPI_OPCODE_UPDATE: CInt = 4
    val DPI_OPCODE_DELETE: CInt = 8
    val DPI_OPCODE_ALTER: CInt = 16
    val DPI_OPCODE_DROP: CInt = 32
    val DPI_OPCODE_UNKNOWN: CInt = 64
    val DPI_ORACLE_TYPE_NONE: CInt = 2000
    val DPI_ORACLE_TYPE_VARCHAR: CInt = 2001
    val DPI_ORACLE_TYPE_NVARCHAR: CInt = 2002
    val DPI_ORACLE_TYPE_CHAR: CInt = 2003
    val DPI_ORACLE_TYPE_NCHAR: CUnsignedInt = 2004.toUInt
    val DPI_ORACLE_TYPE_ROWID: CUnsignedInt = 2005.toUInt
    val DPI_ORACLE_TYPE_RAW: CInt = 2006
    val DPI_ORACLE_TYPE_NATIVE_FLOAT: CInt = 2007
    val DPI_ORACLE_TYPE_NATIVE_DOUBLE: CInt = 2008
    val DPI_ORACLE_TYPE_NATIVE_INT: CInt = 2009
    val DPI_ORACLE_TYPE_NUMBER: CInt = 2010
    val DPI_ORACLE_TYPE_DATE: CInt = 2011
    val DPI_ORACLE_TYPE_TIMESTAMP: CInt = 2012
    val DPI_ORACLE_TYPE_TIMESTAMP_TZ: CInt = 2013
    val DPI_ORACLE_TYPE_TIMESTAMP_LTZ: CInt = 2014
    val DPI_ORACLE_TYPE_INTERVAL_DS: CInt = 2015
    val DPI_ORACLE_TYPE_INTERVAL_YM: CInt = 2016
    val DPI_ORACLE_TYPE_CLOB: CInt = 2017
    val DPI_ORACLE_TYPE_NCLOB: CInt = 2018
    val DPI_ORACLE_TYPE_BLOB: CInt = 2019
    val DPI_ORACLE_TYPE_BFILE: CInt = 2020
    val DPI_ORACLE_TYPE_STMT: CInt = 2021
    val DPI_ORACLE_TYPE_BOOLEAN: CInt = 2022
    val DPI_ORACLE_TYPE_OBJECT: CInt = 2023
    val DPI_ORACLE_TYPE_LONG_VARCHAR: CInt = 2024
    val DPI_ORACLE_TYPE_LONG_RAW: CInt = 2025
    val DPI_ORACLE_TYPE_NATIVE_UINT: CInt = 2026
    val DPI_ORACLE_TYPE_MAX: CInt = 2027
    val DPI_MODE_POOL_CLOSE_DEFAULT: CInt = 0
    val DPI_MODE_POOL_CLOSE_FORCE: CInt = 1
    val DPI_MODE_POOL_GET_WAIT: CInt = 0
    val DPI_MODE_POOL_GET_NOWAIT: CInt = 1
    val DPI_MODE_POOL_GET_FORCEGET: CInt = 2
    val DPI_MODE_POOL_GET_TIMEDWAIT: CInt = 3
    val DPI_PURITY_DEFAULT: CInt = 0
    val DPI_PURITY_NEW: CInt = 1
    val DPI_PURITY_SELF: CInt = 2
    val DPI_MODE_SHUTDOWN_DEFAULT: CInt = 0
    val DPI_MODE_SHUTDOWN_TRANSACTIONAL: CInt = 1
    val DPI_MODE_SHUTDOWN_TRANSACTIONAL_LOCAL: CInt = 2
    val DPI_MODE_SHUTDOWN_IMMEDIATE: CInt = 3
    val DPI_MODE_SHUTDOWN_ABORT: CInt = 4
    val DPI_MODE_SHUTDOWN_FINAL: CInt = 5
    val DPI_SODA_FLAGS_DEFAULT: CInt = 0
    val DPI_SODA_FLAGS_ATOMIC_COMMIT: CInt = 1
    val DPI_SODA_FLAGS_CREATE_COLL_MAP: CInt = 2
    val DPI_SODA_FLAGS_INDEX_DROP_FORCE: CInt = 4
    val DPI_MODE_STARTUP_DEFAULT: CInt = 0
    val DPI_MODE_STARTUP_FORCE: CInt = 1
    val DPI_MODE_STARTUP_RESTRICT: CInt = 2
    val DPI_STMT_TYPE_UNKNOWN: CInt = 0
    val DPI_STMT_TYPE_SELECT: CInt = 1
    val DPI_STMT_TYPE_UPDATE: CInt = 2
    val DPI_STMT_TYPE_DELETE: CInt = 3
    val DPI_STMT_TYPE_INSERT: CInt = 4
    val DPI_STMT_TYPE_CREATE: CInt = 5
    val DPI_STMT_TYPE_DROP: CInt = 6
    val DPI_STMT_TYPE_ALTER: CInt = 7
    val DPI_STMT_TYPE_BEGIN: CInt = 8
    val DPI_STMT_TYPE_DECLARE: CInt = 9
    val DPI_STMT_TYPE_CALL: CInt = 10
    val DPI_STMT_TYPE_EXPLAIN_PLAN: CInt = 15
    val DPI_STMT_TYPE_MERGE: CInt = 16
    val DPI_STMT_TYPE_ROLLBACK: CInt = 17
    val DPI_STMT_TYPE_COMMIT: CInt = 21
    val DPI_SUBSCR_GROUPING_CLASS_TIME: CInt = 1
    val DPI_SUBSCR_GROUPING_TYPE_SUMMARY: CInt = 1
    val DPI_SUBSCR_GROUPING_TYPE_LAST: CInt = 2
    val DPI_SUBSCR_NAMESPACE_AQ: CInt = 1
    val DPI_SUBSCR_NAMESPACE_DBCHANGE: CInt = 2
    val DPI_SUBSCR_PROTO_CALLBACK: CInt = 0
    val DPI_SUBSCR_PROTO_MAIL: CInt = 1
    val DPI_SUBSCR_PROTO_PLSQL: CInt = 2
    val DPI_SUBSCR_PROTO_HTTP: CInt = 3
    val DPI_SUBSCR_QOS_RELIABLE: CInt = 1
    val DPI_SUBSCR_QOS_DEREG_NFY: CInt = 2
    val DPI_SUBSCR_QOS_ROWIDS: CInt = 4
    val DPI_SUBSCR_QOS_QUERY: CInt = 8
    val DPI_SUBSCR_QOS_BEST_EFFORT: CInt = 16
    val DPI_VISIBILITY_IMMEDIATE: CInt = 1
    val DPI_VISIBILITY_ON_COMMIT: CInt = 2
  }

  type enum_dpiErrorNum = CUnsignedInt
  object enum_dpiErrorNum {
    final val DPI_ERR_NO_ERR: enum_dpiErrorNum = 1000.toUInt
    final val DPI_ERR_NO_MEMORY: enum_dpiErrorNum = 1001.toUInt
    final val DPI_ERR_INVALID_HANDLE: enum_dpiErrorNum = 1002.toUInt
    final val DPI_ERR_ERR_NOT_INITIALIZED: enum_dpiErrorNum = 1003.toUInt
    final val DPI_ERR_GET_FAILED: enum_dpiErrorNum = 1004.toUInt
    final val DPI_ERR_CREATE_ENV: enum_dpiErrorNum = 1005.toUInt
    final val DPI_ERR_CONVERT_TEXT: enum_dpiErrorNum = 1006.toUInt
    final val DPI_ERR_QUERY_NOT_EXECUTED: enum_dpiErrorNum = 1007.toUInt
    final val DPI_ERR_UNHANDLED_DATA_TYPE: enum_dpiErrorNum = 1008.toUInt
    final val DPI_ERR_INVALID_ARRAY_POSITION: enum_dpiErrorNum = 1009.toUInt
    final val DPI_ERR_NOT_CONNECTED: enum_dpiErrorNum = 1010.toUInt
    final val DPI_ERR_CONN_NOT_IN_POOL: enum_dpiErrorNum = 1011.toUInt
    final val DPI_ERR_INVALID_PROXY: enum_dpiErrorNum = 1012.toUInt
    final val DPI_ERR_NOT_SUPPORTED: enum_dpiErrorNum = 1013.toUInt
    final val DPI_ERR_UNHANDLED_CONVERSION: enum_dpiErrorNum = 1014.toUInt
    final val DPI_ERR_ARRAY_SIZE_TOO_BIG: enum_dpiErrorNum = 1015.toUInt
    final val DPI_ERR_INVALID_DATE: enum_dpiErrorNum = 1016.toUInt
    final val DPI_ERR_VALUE_IS_NULL: enum_dpiErrorNum = 1017.toUInt
    final val DPI_ERR_ARRAY_SIZE_TOO_SMALL: enum_dpiErrorNum = 1018.toUInt
    final val DPI_ERR_BUFFER_SIZE_TOO_SMALL: enum_dpiErrorNum = 1019.toUInt
    final val DPI_ERR_VERSION_NOT_SUPPORTED: enum_dpiErrorNum = 1020.toUInt
    final val DPI_ERR_INVALID_ORACLE_TYPE: enum_dpiErrorNum = 1021.toUInt
    final val DPI_ERR_WRONG_ATTR: enum_dpiErrorNum = 1022.toUInt
    final val DPI_ERR_NOT_COLLECTION: enum_dpiErrorNum = 1023.toUInt
    final val DPI_ERR_INVALID_INDEX: enum_dpiErrorNum = 1024.toUInt
    final val DPI_ERR_NO_OBJECT_TYPE: enum_dpiErrorNum = 1025.toUInt
    final val DPI_ERR_INVALID_CHARSET: enum_dpiErrorNum = 1026.toUInt
    final val DPI_ERR_SCROLL_OUT_OF_RS: enum_dpiErrorNum = 1027.toUInt
    final val DPI_ERR_QUERY_POSITION_INVALID: enum_dpiErrorNum = 1028.toUInt
    final val DPI_ERR_NO_ROW_FETCHED: enum_dpiErrorNum = 1029.toUInt
    final val DPI_ERR_TLS_ERROR: enum_dpiErrorNum = 1030.toUInt
    final val DPI_ERR_ARRAY_SIZE_ZERO: enum_dpiErrorNum = 1031.toUInt
    final val DPI_ERR_EXT_AUTH_WITH_CREDENTIALS: enum_dpiErrorNum = 1032.toUInt
    final val DPI_ERR_CANNOT_GET_ROW_OFFSET: enum_dpiErrorNum = 1033.toUInt
    final val DPI_ERR_CONN_IS_EXTERNAL: enum_dpiErrorNum = 1034.toUInt
    final val DPI_ERR_TRANS_ID_TOO_LARGE: enum_dpiErrorNum = 1035.toUInt
    final val DPI_ERR_BRANCH_ID_TOO_LARGE: enum_dpiErrorNum = 1036.toUInt
    final val DPI_ERR_COLUMN_FETCH: enum_dpiErrorNum = 1037.toUInt
    final val DPI_ERR_STMT_CLOSED: enum_dpiErrorNum = 1038.toUInt
    final val DPI_ERR_LOB_CLOSED: enum_dpiErrorNum = 1039.toUInt
    final val DPI_ERR_INVALID_CHARSET_ID: enum_dpiErrorNum = 1040.toUInt
    final val DPI_ERR_INVALID_OCI_NUMBER: enum_dpiErrorNum = 1041.toUInt
    final val DPI_ERR_INVALID_NUMBER: enum_dpiErrorNum = 1042.toUInt
    final val DPI_ERR_NUMBER_NO_REPR: enum_dpiErrorNum = 1043.toUInt
    final val DPI_ERR_NUMBER_STRING_TOO_LONG: enum_dpiErrorNum = 1044.toUInt
    final val DPI_ERR_NULL_POINTER_PARAMETER: enum_dpiErrorNum = 1045.toUInt
    final val DPI_ERR_LOAD_LIBRARY: enum_dpiErrorNum = 1046.toUInt
    final val DPI_ERR_LOAD_SYMBOL: enum_dpiErrorNum = 1047.toUInt
    final val DPI_ERR_ORACLE_CLIENT_TOO_OLD: enum_dpiErrorNum = 1048.toUInt
    final val DPI_ERR_NLS_ENV_VAR_GET: enum_dpiErrorNum = 1049.toUInt
    final val DPI_ERR_PTR_LENGTH_MISMATCH: enum_dpiErrorNum = 1050.toUInt
    final val DPI_ERR_NAN: enum_dpiErrorNum = 1051.toUInt
    final val DPI_ERR_WRONG_TYPE: enum_dpiErrorNum = 1052.toUInt
    final val DPI_ERR_BUFFER_SIZE_TOO_LARGE: enum_dpiErrorNum = 1053.toUInt
    final val DPI_ERR_NO_EDITION_WITH_CONN_CLASS: enum_dpiErrorNum = 1054.toUInt
    final val DPI_ERR_NO_BIND_VARS_IN_DDL: enum_dpiErrorNum = 1055.toUInt
    final val DPI_ERR_SUBSCR_CLOSED: enum_dpiErrorNum = 1056.toUInt
    final val DPI_ERR_NO_EDITION_WITH_NEW_PASSWORD: enum_dpiErrorNum = 1057.toUInt
    final val DPI_ERR_UNEXPECTED_OCI_RETURN_VALUE: enum_dpiErrorNum = 1058.toUInt
    final val DPI_ERR_EXEC_MODE_ONLY_FOR_DML: enum_dpiErrorNum = 1059.toUInt
    final val DPI_ERR_ARRAY_VAR_NOT_SUPPORTED: enum_dpiErrorNum = 1060.toUInt
    final val DPI_ERR_EVENTS_MODE_REQUIRED: enum_dpiErrorNum = 1061.toUInt
    final val DPI_ERR_ORACLE_DB_TOO_OLD: enum_dpiErrorNum = 1062.toUInt
    final val DPI_ERR_CALL_TIMEOUT: enum_dpiErrorNum = 1063.toUInt
    final val DPI_ERR_SODA_CURSOR_CLOSED: enum_dpiErrorNum = 1064.toUInt
    final val DPI_ERR_EXT_AUTH_INVALID_PROXY: enum_dpiErrorNum = 1065.toUInt
    final val DPI_ERR_QUEUE_NO_PAYLOAD: enum_dpiErrorNum = 1066.toUInt
    final val DPI_ERR_QUEUE_WRONG_PAYLOAD_TYPE: enum_dpiErrorNum = 1067.toUInt
    final val DPI_ERR_ORACLE_CLIENT_UNSUPPORTED: enum_dpiErrorNum = 1068.toUInt
    final val DPI_ERR_MISSING_SHARDING_KEY: enum_dpiErrorNum = 1069.toUInt
    final val DPI_ERR_MAX: enum_dpiErrorNum = 1070.toUInt
  }

  type dpiErrorNum = enum_dpiErrorNum
  //type dpiHandleTypeNum = enum_dpiHandleTypeNum


  // typedef pthread_mutex_t dpiMutexType
  type dpiMutexType = pthread_mutex_t /// CInt
  // dpiErrorBuffer

  /*
  typedef struct {
      int32_t code;                       // Oracle error code or 0
      uint32_t offset;                    // parse error offset or row offset
      dpiErrorNum errorNum;               // OCPI-C error number
      const char *fnName;                 // ODPI-C function name
      const char *action;                 // internal action
      char encoding[DPI_OCI_NLS_MAXBUFSZ];    // encoding (IANA name)
      char message[DPI_MAX_ERROR_SIZE];   // buffer for storing messages
      uint32_t messageLength;             // length of message in buffer
      int isRecoverable;                  // is recoverable?
      int isWarning;                      // is a warning?
  } dpiErrorBuffer;
   */
  type dpiErrorBuffer = CStruct10[
    CInt,
    CUnsignedInt,
    dpiErrorNum,
    CString,
    CString,
    CArray[CChar, Digit3[_1, _0, _0]],
    CArray[CChar, Digit4[_3, _0, _7, _2]],
    CUnsignedInt,
    CInt,
    CInt]



  /*
  typedef struct {
      dpiErrorBuffer *buffer;             // buffer to store error information
      void *handle;                       // OCI error handle or NULL
      dpiEnv *env;                        // env which created OCI error handle
  } dpiError;
   */
  type struct_dpiError = CStruct3[
    Ptr[dpiErrorBuffer],
    Ptr[Byte],
    Ptr[struct_dpiEnv]]

  type dpiError = struct_dpiError


  // dpiVersionInfo
  /*// structure used for transferring version information
struct dpiVersionInfo {
    int versionNum;
    int releaseNum;
    int updateNum;
    int portReleaseNum;
    int portUpdateNum;
    uint32_t fullVersionNum;
};*/
  type struct_dpiVersionInfo = CStruct6[
    CInt,
    CInt,
    CInt,
    CInt,
    CInt,
    CUnsignedInt
  ]


  /// dpiType_HEAD
  /*
  #define dpiType_HEAD \
    const dpiTypeDef *typeDef; \
    uint32_t checkInt; \
    unsigned refCount; \
    dpiEnv *env;
*/
  type struct_dpiType_HEAD = CStruct4[
    Ptr[struct_dpiTypeDef],
    CUnsignedInt,
    CUnsignedInt,
    Ptr[struct_dpiEnv]
  ]


  /*
  typedef struct {
    const char *name;                   // name (used in error messages)
    size_t size;                        // size of structure, in bytes
    uint32_t checkInt;                  // check integer (unique)
    dpiTypeFreeProc freeProc;           // procedure to call to free handle
  } dpiTypeDef;
  */
  type struct_dpiTypeDef = CStruct4[
    CString,
    CSize,
    CUnsignedInt,
    //CFuncPtr1[CString, Unit]
    CFuncPtr2[Ptr[Byte], Ptr[dpiError], Unit]
  ]

  // DPIEnv
  /*
  typedef struct {
    const dpiContext *context;          // context used to create environment
    void *handle;                       // OCI environment handle
    dpiMutexType mutex;                 // for reference count (threaded mode)
    char encoding[DPI_OCI_NLS_MAXBUFSZ];    // CHAR encoding (IANA name)
    int32_t maxBytesPerCharacter;       // max bytes per CHAR character
    uint16_t charsetId;                 // CHAR encoding (Oracle charset ID)
    char nencoding[DPI_OCI_NLS_MAXBUFSZ];   // NCHAR encoding (IANA name)
    int32_t nmaxBytesPerCharacter;      // max bytes per NCHAR character
    uint16_t ncharsetId;                // NCHAR encoding (Oracle charset ID)
    dpiHandlePool *errorHandles;        // pool of OCI error handles
    dpiVersionInfo *versionInfo;        // OCI client version info
    void *baseDate;                     // timestamp
    void *baseDateTZ;                   // timestamp with time zone
    void *baseDateLTZ;                  // timestamp with local time zone
    int threaded;                       // threaded mode enabled?
    int events;                         // events mode enabled?
    int externalHandle;                 // external handle?
} dpiEnv;
   */
  type struct_dpiEnv = CStruct17[
    Ptr[CInt], // why not Ptr[DPIContext] ? to avoid circularity ?
    Ptr[Byte],
    dpiMutexType,
    CArray[CChar, Digit3[_1, _0, _0]],
    CInt,
    CUnsignedShort,
    CArray[CChar, Digit3[_1, _0, _0]],
    CInt,
    CUnsignedShort,
    Ptr[struct_dpiHandlePool],
    Ptr[CInt], // why not Ptr[struct_dpiVersionInfo] ?
    Ptr[Byte],
    Ptr[Byte],
    Ptr[Byte],
    CInt,
    CInt,
    CInt]

  /*
  typedef struct {
    void **handles;                     // array of handles managed by pool
    uint32_t numSlots;                  // length of handles array
    uint32_t numUsedSlots;              // actual number of managed handles
    uint32_t acquirePos;                // position from which to acquire
    uint32_t releasePos;                // position to place released handles
    dpiMutexType mutex;                 // enables thread safety
  } dpiHandlePool;
*/
  type struct_dpiHandlePool = CStruct6[
    Ptr[Ptr[Byte]],
    CUnsignedInt,
    CUnsignedInt,
    CUnsignedInt,
    CUnsignedInt,
    dpiMutexType
  ]

  /*struct dpiVersionInfo {
    int versionNum;
    int releaseNum;
    int updateNum;
    int portReleaseNum;
    int portUpdateNum;
    uint32_t fullVersionNum;
};*/
  type DPIVersionInfo = CStruct6[
    CInt,
    CInt,
    CInt,
    CInt,
    CInt,
    CUnsignedInt
  ]





  /*
    struct dpiContext {
       dpiType_HEAD
       dpiVersionInfo *versionInfo;        // OCI client version info
       uint8_t dpiMinorVersion;            // ODPI-C minor version of application
   }; */
  type struct_dpiContext = CStruct3[
    struct_dpiType_HEAD,
    Ptr[CInt],   // why not Ptr[struct_dpiVersionInfo], to avoid circularity ?
    CUnsignedShort]


  /*
  struct dpiErrorInfo {
    int32_t code;
    uint16_t offset16;
    const char *message;
    uint32_t messageLength;
    const char *encoding;
    const char *fnName;
    const char *action;
    const char *sqlState;
    int isRecoverable;
    int isWarning;
    uint32_t offset;
  };
*/
  type struct_dpiErrorInfo = CStruct11[
    CInt,
    CUnsignedShort,
    CString,
    CUnsignedInt,
    CString,
    CString,
    CString,
    CString,
    CInt,
    CInt,
    CUnsignedInt]


  /*
DPI_EXPORT int dpiContext_create(unsigned int majorVersion,
        unsigned int minorVersion, dpiContext **context,
        dpiErrorInfo *errorInfo);
 */
  def dpiContext_create(
                         majorVersion: CUnsignedInt,
                         minorVersion: CUnsignedInt,
                         context: Ptr[Ptr[struct_dpiContext]],
                         errorInfo: Ptr[struct_dpiErrorInfo]): CInt = extern



  /*
  struct dpiPool {
    dpiType_HEAD
    void *handle;                       // OCI session pool handle
    const char *name;                   // pool name (CHAR encoding)
    uint32_t nameLength;                // length of pool name
    int pingInterval;                   // interval (seconds) between pings
    int pingTimeout;                    // timeout (milliseconds) for ping
    int homogeneous;                    // homogeneous pool?
    int externalAuth;                   // use external authentication?
};  */
  type struct_dpiPool = CStruct8[
    struct_dpiType_HEAD,
    Ptr[Byte],
    CString,
    CUnsignedInt,
    CInt,
    CInt,
    CInt,
    CInt]

  /*
    typedef struct {
      void **handles;                     // array of handles managed by list
      uint32_t numSlots;                  // length of handles array
      uint32_t numUsedSlots;              // actual number of managed handles
      uint32_t currentPos;                // next position to search
      dpiMutexType mutex;                 // enables thread safety
    } dpiHandleList;
  */
  type struct_anonymous_9 = CStruct5[Ptr[Ptr[Byte]], CUnsignedInt, CUnsignedInt, CUnsignedInt, dpiMutexType]
  type dpiHandleList = struct_anonymous_9


  /*
  struct dpiConn {
    dpiType_HEAD
    dpiPool *pool;                      // pool acquired from or NULL
    void *handle;                       // OCI service context handle
    void *serverHandle;                 // OCI server handle
    void *sessionHandle;                // OCI session handle
    void *shardingKey;                  // OCI sharding key descriptor
    void *superShardingKey;             // OCI supper sharding key descriptor
    const char *releaseString;          // cached release string or NULL
    uint32_t releaseStringLength;       // cached release string length or 0
    void *rawTDO;                       // cached RAW TDO
    dpiVersionInfo versionInfo;         // Oracle database version info
    uint32_t commitMode;                // commit mode (for two-phase commits)
    uint16_t charsetId;                 // database character set ID
    dpiHandleList *openStmts;           // list of statements created
    dpiHandleList *openLobs;            // list of LOBs created
    dpiHandleList *objects;             // list of objects created
    int externalHandle;                 // OCI handle provided directly?
    int deadSession;                    // dead session (drop from pool)?
    int standalone;                     // standalone connection (not pooled)?
    int closing;                        // connection is being closed?
};

   */

  type struct_dpiConn = CStruct20[
    struct_dpiType_HEAD,
    Ptr[struct_dpiPool],
    Ptr[Byte],
    Ptr[Byte],
    Ptr[Byte],
    Ptr[Byte],
    Ptr[Byte],
    CString,
    CUnsignedInt,
    Ptr[Byte],
    Ptr[struct_dpiVersionInfo],
    CUnsignedInt,
    CUnsignedShort,
    Ptr[dpiHandleList],
    Ptr[dpiHandleList],
    Ptr[dpiHandleList],
    CInt,
    CInt,
    CInt,
    CInt
  ]



  /*// structure used for application context
    struct dpiAppContext {
        const char *namespaceName;
        uint32_t namespaceNameLength;
        const char *name;
        uint32_t nameLength;
        const char *value;
        uint32_t valueLength;
    };
    */
  type struct_dpiAppContext = CStruct6[CString, CUnsignedInt, CString, CUnsignedInt, CString, CUnsignedInt]

  //typedef uint32_t dpiOracleTypeNum;
  type dpiOracleTypeNum = CUnsignedInt
  type dpiNativeTypeNum = CUnsignedInt
  type union_anonymous_2 = CArray[Byte, _1]

  /*
  struct dpiShardingKeyColumn {
    dpiOracleTypeNum oracleTypeNum;
    dpiNativeTypeNum nativeTypeNum;
    dpiDataBuffer value;
};
   */
  type struct_dpiShardingKeyColumn = CStruct3[dpiOracleTypeNum, dpiNativeTypeNum, union_anonymous_2]
  type dpiShardingKeyColumn = struct_dpiShardingKeyColumn

  type dpiConn = struct_dpiConn
  type dpiConnCreateParams = struct_dpiConnCreateParams
  //typedef uint32_t dpiAuthMode;
  type dpiAuthMode = CUnsignedInt
  //typedef uint32_t dpiPurity;
  type dpiPurity = CUnsignedInt

  /*// structure used for creating connections
struct dpiConnCreateParams {
    dpiAuthMode authMode;
    const char *connectionClass;
    uint32_t connectionClassLength;
    dpiPurity purity;
    const char *newPassword;
    uint32_t newPasswordLength;
    dpiAppContext *appContext;
    uint32_t numAppContext;
    int externalAuth;
    void *externalHandle;
    dpiPool *pool;
    const char *tag;
    uint32_t tagLength;
    int matchAnyTag;
    const char *outTag;
    uint32_t outTagLength;
    int outTagFound;
    dpiShardingKeyColumn *shardingKeyColumns;
    uint8_t numShardingKeyColumns;
    dpiShardingKeyColumn *superShardingKeyColumns;
    uint8_t numSuperShardingKeyColumns;
    int outNewSession;
};
*/

  type struct_dpiConnCreateParams = CStruct22[
    dpiAuthMode,
    CString,
    CUnsignedInt,
    dpiPurity,
    CString,
    CUnsignedInt,
    Ptr[struct_dpiAppContext],
    CUnsignedInt,
    CInt,
    Ptr[Byte],
    Ptr[struct_dpiPool],
    CString,
    CUnsignedInt,
    CInt,
    CString,
    CUnsignedInt,
    CInt,
    Ptr[dpiShardingKeyColumn],
    CUnsignedChar,
    Ptr[dpiShardingKeyColumn],
    CUnsignedChar,
    CInt]

  //typedef uint32_t dpiCreateMode;
  type dpiCreateMode = CUnsignedInt

  /*
  struct dpiCommonCreateParams {
    dpiCreateMode createMode;
    const char *encoding;
    const char *nencoding;
    const char *edition;
    uint32_t editionLength;
    const char *driverName;
    uint32_t driverNameLength;
};   */
  type struct_dpiCommonCreateParams = CStruct7[dpiCreateMode, CString, CString, CString, CUnsignedInt, CString, CUnsignedInt]
  type dpiCommonCreateParams = struct_dpiCommonCreateParams


  /*
    // create a connection and return a reference to it
  DPI_EXPORT int dpiConn_create(const dpiContext *context, const char *userName,
          uint32_t userNameLength, const char *password, uint32_t passwordLength,
          const char *connectString, uint32_t connectStringLength,
          const dpiCommonCreateParams *commonParams,
          dpiConnCreateParams *createParams, dpiConn **conn);
     */
  def dpiConn_create(
                      context: Ptr[struct_dpiContext],
                      userName: CString,
                      userNameLength: CUnsignedInt,
                      password: CString,
                      passwordLength: CUnsignedInt,
                      connectString: CString,
                      connectStringLength: CUnsignedInt,
                      commonParams: Ptr[dpiCommonCreateParams],
                      createParams: Ptr[dpiConnCreateParams],
                      conn: Ptr[Ptr[dpiConn]]): CInt = extern


  def dpiContext_initConnCreateParams(context: Ptr[struct_dpiContext], params: Ptr[dpiConnCreateParams]): CInt = extern


  def dpiContext_getError(context: Ptr[struct_dpiContext], errorInfo: Ptr[struct_dpiErrorInfo]): Unit = extern
  def dpiConn_newVar(
                      conn: Ptr[dpiConn],
                      oracleTypeNum: dpiOracleTypeNum,
                      nativeTypeNum: dpiNativeTypeNum,
                      maxArraySize: CUnsignedInt,
                      size: CUnsignedInt,
                      sizeIsBytes: CUnsignedInt,
                      isArray: CInt,
                      objType: Ptr[dpiObjectType],
                      `var`: Ptr[Ptr[dpiVar]],
                      data: Ptr[Ptr[dpiData]]): CInt = extern

  /*
// represents the different types of Oracle data that the library supports; an
// array of these structures (defined as constants) can be found in the file
// dpiOracleType.c; the enumeration dpiOracleTypeNum is used to identify the
// structures
typedef struct dpiOracleType {
    dpiOracleTypeNum oracleTypeNum;     // enumeration value identifying type
    dpiNativeTypeNum defaultNativeTypeNum;  // default native (C) type
    uint16_t oracleType;                // OCI type code
    uint8_t charsetForm;                // specifies CHAR or NCHAR encoding
    uint32_t sizeInBytes;               // buffer size (fixed) or 0 (variable)
    int isCharacterData;                // is type character data?
    int canBeInArray;                   // can type be in an index-by table?
    int requiresPreFetch;               // prefetch processing required?
} dpiOracleType;
 */
  type dpiOracleType = CStruct8[
    dpiOracleTypeNum,
    dpiNativeTypeNum,
    CUnsignedShort,
    CUnsignedChar,
    CUnsignedInt, CInt, CInt, CInt]

  /*
  struct dpiDataTypeInfo {
    dpiOracleTypeNum oracleTypeNum;
    dpiNativeTypeNum defaultNativeTypeNum;
    uint16_t ociTypeCode;
    uint32_t dbSizeInBytes;
    uint32_t clientSizeInBytes;
    uint32_t sizeInChars;
    int16_t precision;
    int8_t scale;
    uint8_t fsPrecision;
    dpiObjectType *objectType;
};*/
  type dpiDataTypeInfo = CStruct10[
    dpiOracleTypeNum,
    dpiNativeTypeNum,
    CUnsignedShort,
    CUnsignedInt, CUnsignedInt, CUnsignedInt,
    CShort, CSignedChar, CUnsignedChar,
    Ptr[CInt] // avoid cyclic Ptr[dpiObjectType]
  ]


  /*
  struct dpiObjectType {
    dpiType_HEAD
    dpiConn *conn;                      // connection which created this
    void *tdo;                          // OCI type descriptor object
    uint16_t typeCode;                  // OCI type code
    const char *schema;                 // schema owning type (CHAR encoding)
    uint32_t schemaLength;              // length of schema owning type
    const char *name;                   // name of type (CHAR encoding)
    uint32_t nameLength;                // length of name of type
    dpiDataTypeInfo elementTypeInfo;    // type info of elements of collection
    int isCollection;                   // is type a collection?
    uint16_t numAttributes;             // number of attributes type has
};
   */
  type dpiObjectType = CStruct11[
    struct_dpiType_HEAD,
    Ptr[struct_dpiConn],
    Ptr[Byte],
    CUnsignedShort,
    CString,
    CUnsignedInt,
    CString,
    CUnsignedInt,
    dpiDataTypeInfo,
    CInt,
    CUnsignedShort]

  /*
  typedef union {
      void *asHandle;
      dpiObject *asObject;
      dpiStmt *asStmt;
      dpiLob *asLOB;
      dpiRowid *asRowid;
  } dpiReferenceBuffer;
   */
  type dpiReferenceBuffer = CArray[Byte, _1]

  /*
  typedef struct {
    char *ptr;                          // pointer to buffer
    uint32_t length;                    // actual length of buffer
    uint32_t allocatedLength;           // allocated length of buffer
} dpiDynamicBytesChunk;
   */

  type dpiDynamicBytesChunk = CStruct3[CString, CUnsignedInt, CUnsignedInt]

  /*
  typedef struct {
    uint32_t numChunks;                 // actual number of chunks
    uint32_t allocatedChunks;           // allocated number of chunks
    dpiDynamicBytesChunk *chunks;       // array of chunks
} dpiDynamicBytes;

   */
  type dpiDynamicBytes = CStruct3[CUnsignedInt, CUnsignedInt, Ptr[dpiDynamicBytesChunk]]


  /*
  typedef union {
      void *asRaw;
      char *asBytes;
      float *asFloat;
      double *asDouble;
      int32_t *asInt32;
      int64_t *asInt64;
      uint64_t *asUint64;
      dpiOciNumber *asNumber;
      dpiOciDate *asDate;
      void **asTimestamp;
      void **asInterval;
      void **asLobLocator;
      void **asString;
      void **asRawData;
      void **asStmt;
      void **asRowid;
      int *asBoolean;
      void **asObject;
      void **asCollection;
  } dpiOracleData;
   */
  type dpiOracleData = CArray[Byte, _1]


  /*
    typedef struct {
      char *ptr;
      uint32_t length;
      const char *encoding;
    } dpiBytes;
  */
  type dpiBytes = CStruct3[CString, CUnsignedInt, CString]

  /*
typedef union {
    int asBoolean;
    int64_t asInt64;
    uint64_t asUint64;
    float asFloat;
    double asDouble;
    dpiBytes asBytes;
    dpiTimestamp asTimestamp;
    dpiIntervalDS asIntervalDS;
    dpiIntervalYM asIntervalYM;
    dpiLob *asLOB;
    dpiObject *asObject;
    dpiStmt *asStmt;
    dpiRowid *asRowid;
} dpiDataBuffer; */
  type dpiDataBuffer = CArray[Byte, Digit4[_1, _0, _2, _4]]
  //type dpiDataBuffer = dpiBytes
  //type dpiDataBuffer = dpiBytes | CInt

  /*
  // structure used for transferring data to/from ODPI-C
  struct dpiData {
      int isNull;
      dpiDataBuffer value;
  }; */
  type dpiData = CStruct2[CInt, dpiDataBuffer]
  type dpiDataDpiBytes = CStruct2[CInt, dpiBytes]

  /*
typedef struct {
    uint32_t maxArraySize;              // max number of rows in arrays
    uint32_t actualArraySize;           // actual number of rows in arrays
    int16_t *indicator;                 // array of indicator values
    uint16_t *returnCode;               // array of return code values
    uint16_t *actualLength16;           // array of actual lengths (11.2 only)
    uint32_t *actualLength32;           // array of actual lengths (12.1+)
    void **objectIndicator;             // array of object indicator values
    dpiReferenceBuffer *references;     // array of references (specific types)
    dpiDynamicBytes *dynamicBytes;      // array of dynamically alloced chunks
    char *tempBuffer;                   // buffer for numeric conversion
    dpiData *externalData;              // array of buffers (externally used)
    dpiOracleData data;                 // Oracle data buffers (internal only)
} dpiVarBuffer;
 */
  type dpiVarBuffer = CStruct12[
    CUnsignedInt,
    CUnsignedInt,
    Ptr[CShort],
    Ptr[CUnsignedShort],
    Ptr[CUnsignedShort],
    Ptr[CUnsignedInt],
    Ptr[Ptr[Byte]],
    Ptr[dpiReferenceBuffer],
    Ptr[dpiDynamicBytes],
    CString,
    Ptr[dpiData],
    dpiOracleData]

  /*
  // represents memory areas used for transferring data to and from the database
  // and is exposed publicly as a handle of type DPI_HTYPE_VAR; the
  // implementation for this is found in the file dpiVar.c; variables can be
  // bound to a statement or fetched into by a statement
  struct dpiVar {
    dpiType_HEAD
    dpiConn *conn;                      // connection which created this
    const dpiOracleType *type;          // type of data contained in variable
    dpiNativeTypeNum nativeTypeNum;     // native (C) type of data
    int requiresPreFetch;               // requires prefetch processing?
    int isArray;                        // is an index-by table (array)?
    uint32_t sizeInBytes;               // size in bytes of each row
    int isDynamic;                      // dynamically bound or defined?
    dpiObjectType *objectType;          // object type (or NULL)
    dpiVarBuffer buffer;                // main buffer for data
    dpiVarBuffer *dynBindBuffers;       // array of buffers (DML returning)
    dpiError *error;                    // error (only for dynamic bind/define)
  };*/
  type dpiVar = CStruct12[
    struct_dpiType_HEAD,
    Ptr[struct_dpiConn],
    Ptr[dpiOracleType],
    dpiNativeTypeNum,
    CInt,
    CInt,
    CUnsignedInt,
    CInt,
    Ptr[dpiObjectType],
    dpiVarBuffer,
    Ptr[dpiVarBuffer],
    Ptr[dpiError]
  ]

  /*
  struct dpiQueryInfo {
    const char *name;
    uint32_t nameLength;
    dpiDataTypeInfo typeInfo;
    int nullOk;
};   */
  type dpiQueryInfo = CStruct4[CString, CUnsignedInt, dpiDataTypeInfo, CInt]

  /*
  typedef struct {
    dpiVar *var;
    uint32_t pos;
    const char *name;
    uint32_t nameLength;
} dpiBindVar;
   */
  type dpiBindVar = CStruct4[Ptr[CInt], CUnsignedInt, CString, CUnsignedInt]


  /*
  struct dpiStmt {
    dpiType_HEAD
    dpiConn *conn;                      // connection which created this
    uint32_t openSlotNum;               // slot in connection handle list
    void *handle;                       // OCI statement handle
    dpiStmt *parentStmt;                // parent statement (implicit results)
    uint32_t fetchArraySize;            // rows to fetch each time
    uint32_t bufferRowCount;            // number of rows in fetch buffers
    uint32_t bufferRowIndex;            // index into buffers for current row
    uint32_t numQueryVars;              // number of query variables
    dpiVar **queryVars;                 // array of query variables
    dpiQueryInfo *queryInfo;            // array of query metadata
    uint32_t allocatedBindVars;         // number of allocated bind variables
    uint32_t numBindVars;               // actual nubmer of bind variables
    dpiBindVar *bindVars;               // array of bind variables
    uint32_t numBatchErrors;            // number of batch errors
    dpiErrorBuffer *batchErrors;        // array of batch errors
    uint64_t rowCount;                  // rows affected or rows fetched so far
    uint64_t bufferMinRow;              // row num of first row in buffers
    uint16_t statementType;             // type of statement
    dpiRowid *lastRowid;                // rowid of last affected row
    int isOwned;                        // owned by structure?
    int hasRowsToFetch;                 // potentially more rows to fetch?
    int scrollable;                     // scrollable cursor?
    int isReturning;                    // statement has RETURNING clause?
    int deleteFromCache;                // drop from statement cache on close?
    int closing;                        // statement is being closed?
};
   */
  type subStruct = CStruct6[CInt, CInt, CInt, CInt, CInt, CInt]

  type dpiStmt = CStruct21[
    struct_dpiType_HEAD,
    Ptr[struct_dpiConn],
    CUnsignedInt,
    Ptr[Byte],
    Ptr[Byte],
    CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt,
    Ptr[Ptr[CInt]], // should be dpiVar but for cyclic avoidance
    Ptr[dpiQueryInfo],
    CUnsignedInt, CUnsignedInt,
    Ptr[dpiBindVar],
    CUnsignedInt,
    Ptr[dpiErrorBuffer],
    CUnsignedLongLong, CUnsignedLongLong, CUnsignedLongLong,
    Ptr[dpiRowid],
    subStruct
  ]

  /*
  // prepare a statement and return it for subsequent execution/fetching
  DPI_EXPORT int dpiConn_prepareStmt(dpiConn *conn, int scrollable,
          const char *sql, uint32_t sqlLength, const char *tag,
          uint32_t tagLength, dpiStmt **stmt);
   */
  def dpiConn_prepareStmt(
                           conn: Ptr[dpiConn],
                           scrollable: CInt,
                           sql: CString,
                           sqlLength: CUnsignedInt,
                           tag: CString,
                           tagLength: CUnsignedInt,
                           stmt: Ptr[Ptr[dpiStmt]]): CInt = extern

  // typedef uint32_t dpiExecMode;
  type dpiExecMode = CUnsignedInt

  /*
  // execute the statement and return the number of query columns
// zero implies the statement is not a query
DPI_EXPORT int dpiStmt_execute(dpiStmt *stmt, dpiExecMode mode,
        uint32_t *numQueryColumns);
   */
  def dpiStmt_execute(stmt: Ptr[dpiStmt], mode: dpiExecMode, numQueryColumns: Ptr[CUnsignedInt]): CInt = extern
  /*
  // fetch a single row and return the index into the defined variables
  // this will internally perform any execute and array fetch as needed
  DPI_EXPORT int dpiStmt_fetch(dpiStmt *stmt, int *found,
          uint32_t *bufferRowIndex);
   */
  def dpiStmt_fetch(stmt: Ptr[dpiStmt], found: Ptr[CInt], bufferRowIndex: Ptr[CUnsignedInt]): CInt = extern
  // get the value for the specified column of the current row fetched
  /*  DPI_EXPORT int dpiStmt_getQueryValue(dpiStmt *stmt, uint32_t pos,
      dpiNativeTypeNum *nativeTypeNum, dpiData **data);*/
  def dpiStmt_getQueryValue(
                             stmt: Ptr[dpiStmt],
                             pos: CUnsignedInt,
                             nativeTypeNum: Ptr[dpiNativeTypeNum],
                             data: Ptr[Ptr[dpiData]]):CInt = extern


  /*
    struct dpiRowid {
      dpiType_HEAD
      void *handle;                       // OCI rowid descriptor
      char *buffer;                       // cached string rep (or NULL)
      uint16_t bufferLength;              // length of string rep (or 0)
    };*/
  type dpiRowid = CStruct4[
    struct_dpiType_HEAD,
    Ptr[Byte],
    CString,
    CUnsignedShort]

  /*
  // get string representation from rowid
  DPI_EXPORT int dpiRowid_getStringValue(dpiRowid *rowid, const char **value,
          uint32_t *valueLength); */
  def dpiRowid_getStringValue(rowid: Ptr[dpiRowid], value: Ptr[CString], valueLength: Ptr[CUnsignedInt]): CInt = extern

  /*
// set the value of the variable from a rowid
DPI_EXPORT int dpiVar_setFromRowid(dpiVar *var, uint32_t pos, dpiRowid *rowid);
   */
  def dpiVar_setFromRowid(`var`: Ptr[dpiVar], pos: CUnsignedInt, rowid: Ptr[dpiRowid]): CInt = extern

}
