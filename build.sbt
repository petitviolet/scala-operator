val VERSION = "0.2.3"

val GROUP_ID = "net.petitviolet"

val PROJECT_NAME = "operator"


lazy val commonDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

lazy val commonSettings = Seq(
  version := VERSION,
  organization := GROUP_ID,
  scalaVersion := "2.12.1",
  crossScalaVersions := Seq("2.11.8", "2.12.1")
)

lazy val root = (project in file("."))
  .settings(commonSettings, name := "root")
  .aggregate(example, operator)

lazy val example = (project in file("modules/example"))
  .settings(commonSettings, name := "example")
//  .settings(libraryDependencies += GROUP_ID %% PROJECT_NAME % VERSION)
  .settings(scalacOptions += "-Xlog-implicits")
  .dependsOn(operator)

lazy val operator = (project in file(s"modules/$PROJECT_NAME"))
  .settings(
    commonSettings,
    name := PROJECT_NAME,
    libraryDependencies ++= commonDependencies
  )
//  .settings(testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", {val dir = System.getenv("CI_REPORTS"); if(dir == null) "target/reports" else dir} ))
//  .settings(testOptions in Test += Tests.Argument("-oI"))

