name := """templ"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)
libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
libraryDependencies += "com.typesafe.play" % "anorm_2.11" % "2.4.0-M1"
libraryDependencies += "com.heroku.sdk" % "heroku-jdbc" % "0.1.0"
libraryDependencies += evolutions

libraryDependencies +="org.scalatestplus" %% "play" % "1.1.0" % "test"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
