name := "ScalaNativeOracleConnect"
enablePlugins(ScalaNativePlugin)


val homeDir = sys.env.get("HOME").getOrElse("HOME env variable not exported")
val linkPath = "-L" + homeDir + "/lib"
scalaVersion := "2.11.8"
scalacOptions ++= Seq("-feature")
nativeLinkingOptions ++= Seq(linkPath)
nativeMode := "debug"
nativeGC := "immix"