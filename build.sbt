name := "ciris-test"

version := "0.1"

scalaVersion := "2.12.6"

val enumeratumVersion = "1.5.13"
val cirisVersion = "0.9.2"

libraryDependencies ++= Seq(
  "com.beachape" %% "enumeratum" % enumeratumVersion
)

libraryDependencies ++= Seq(
  "is.cir" %% "ciris-cats",
  "is.cir" %% "ciris-cats-effect",
  "is.cir" %% "ciris-core",
  "is.cir" %% "ciris-enumeratum",
  "is.cir" %% "ciris-generic",
  "is.cir" %% "ciris-refined",
  "is.cir" %% "ciris-spire",
  "is.cir" %% "ciris-squants"
).map(_ % cirisVersion)
