# Scala Native Oracle Connect

Example of Scala Native code connecting and fetching data from Oracle database using Oracle ODPI-C API.

## References

|      | What                | URL                                                          |
| ---- | ------------------- | ------------------------------------------------------------ |
| 1    | Scala Native Gitter | https://gitter.im/scala-native/scala-native?at=5d6962a238499c13a6706a65 |
| 2    |                     | https://github.com/scala-native/scala-native-bindgen         |
| 3    | ODPI-C              | https://oracle.github.io/odpi/                               |
| 4    |                     | https://oracle.github.io/odpi/doc/functions/dpiStmt.html     |

## Installation

You need to install ODPI-C (see [3] above). It means:

- Install Oracle Instant Client

- Put all the content of the install in ~/lib

- compile ODPI-C

  ```
  make
  ```

- Put the lib in ~/lib

- Add an export of DYLD_LIBRARY_PATH env variable in your .bash_profile

  ```
  export DYLD_LIBRARY_PATH=~/lib:$DYLD_LIBRARY_PATH
  ```

  

## Execute

You need 4 application arguments:

| Argument                 | Remark                                                       |
| ------------------------ | ------------------------------------------------------------ |
| Oracle user name         |                                                              |
| Oracle password          |                                                              |
| Oracle connection string |                                                              |
| SQL text                 | should be a select return many rows and selecting 2 columns of type string.<br />Example: <br />`select first_name, last_name from PERSON where PERSON_ID < 10` |

Example:

```
sbt run username password connectionstring sqltext
```

