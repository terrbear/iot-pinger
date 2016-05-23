name := """natertot"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"

libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.0.0"

libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "1.0.0"

