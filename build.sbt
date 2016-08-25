name := "scala_examples"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "Fabricator" at "http://dl.bintray.com/biercoff/Fabricator"
)

libraryDependencies ++= Seq(
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.jsoup" % "jsoup" % "1.8.3",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "org.postgresql" % "postgresql" % "9.4.1208",
  "com.github.azakordonets" % "fabricator_2.10" % "2.1.2",
  "org.scala-lang" % "scala-actors" % "2.11.8",
  "com.typesafe.akka" %% "akka-actor" % "2.4.8"
)

