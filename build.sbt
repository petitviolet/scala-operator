val VERSION = "0.4.0"

val GROUP_ID = "net.petitviolet"

val PROJECT_NAME = "operator"

val SCALA = "2.12.6"

lazy val commonDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

lazy val commonSettings = Seq(
  version := VERSION,
  organization := GROUP_ID,
  scalaVersion := SCALA
)

lazy val root = (project in file("."))
  .settings(commonSettings, name := "root")
  .aggregate(example, operator)

lazy val example = (project in file("modules/example"))
  .settings(commonSettings, name := "example")
  .settings(scalacOptions += "-Xlog-implicits")
// .settings(libraryDependencies += GROUP_ID %% PROJECT_NAME % VERSION)
  .dependsOn(operator)

lazy val operator = (project in file(s"modules/$PROJECT_NAME"))
  .settings(commonSettings: _*)
  .settings(
    name := PROJECT_NAME,
    libraryDependencies ++= commonDependencies,
    crossScalaVersions := Seq("2.11.11", SCALA)
  )
  .settings(testOptions in Test += Tests.Argument("-oI"))
  .settings(testOptions in Test += Tests.Argument(
    TestFrameworks.ScalaTest, "-u", {
      val dir = System.getenv("CI_REPORTS")
      if(dir == null) "target/reports" else dir
    })
  )

