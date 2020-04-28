name := "ScalaNativeOracleConnect"
enablePlugins(ScalaNativePlugin)

scalaVersion := "2.11.8"
scalacOptions ++= Seq("-feature")
nativeLinkingOptions ++= Seq("-L/Users/dschoen/lib")
nativeMode := "debug"
nativeGC := "immix"