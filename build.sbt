name := "Rattata"

organization := "me.azard"

version := "1.0.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scala-lang"                  %     "scala-reflect"         % scalaVersion.value,
  "org.scala-lang"                  %     "scala-compiler"        % scalaVersion.value      % "provided",
  "org.scala-lang"                  %     "scala-compiler"        % scalaVersion.value      % "test"
)