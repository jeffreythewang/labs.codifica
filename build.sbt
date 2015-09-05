name := "labs"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/",
  "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"
)

libraryDependencies ++= Seq(
  "javax.inject"       % "javax.inject"        % "1",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.10.5.0.akka23",
  "org.webjars"       %% "webjars-play"        % "2.3.0-3",
  "org.webjars"        % "react"               % "0.13.1"
)
