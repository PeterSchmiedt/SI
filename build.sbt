name := "si_mikroprojekt2"

version := "1.0"

lazy val `si_mikroprojekt2` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.7.Final",
  "org.hibernate" % "hibernate-core" % "4.3.7.Final",
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)

javaOptions in Test += "-Dconfig.file=conf/test.conf"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )