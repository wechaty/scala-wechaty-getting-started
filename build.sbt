name := "scala-sbt-wechaty-getting-started"

version := "0.1"

scalaVersion := "2.12.14"

val wechaty = "io.github.wechaty" %% "wechaty" % "0.0.15"
val apacheCommons = "org.apache.commons" % "commons-text" % "1.9"

libraryDependencies ++= Seq(wechaty,  apacheCommons)