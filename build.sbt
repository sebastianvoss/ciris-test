name := "ciris-test"

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

javaOptions in Universal ++= Seq(
  "-J-Xmx2048m",
  "-J-XshowSettings:all"
)

enablePlugins(
  JavaAppPackaging,
  BuildInfoPlugin,
  GitVersioning
)

maintainer in Docker := "Sebastian Voss <sebastian.voss@eon.com>"
dockerBaseImage := "anapsix/alpine-java:8_server-jre_unlimited"
dockerExposedPorts := Seq(8080)
dockerUpdateLatest := true

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)
buildInfoPackage := "com.sebastianvoss.buildinfo"
buildInfoOptions += BuildInfoOption.ToJson
buildInfoOptions += BuildInfoOption.BuildTime
