name := """talk-to-redis"""

version := "1.0"

scalaVersion := "2.11.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaVersion = "2.3.7"
  val akkaStreamVersion = "1.0-M1"
  Seq(
    "com.typesafe.akka" %% "akka-actor"      % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit"    % akkaVersion,
    "ch.qos.logback"    % "logback-classic"  % "1.1.2",
    "com.typesafe.akka" %  "akka-stream-experimental_2.11" % akkaStreamVersion,
    "com.typesafe.akka" %  "akka-http-experimental_2.11" % akkaStreamVersion
  )
}
