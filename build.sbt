val VERSION = "0.7.0"

val GROUP_ID = "net.petitviolet"

val PROJECT_NAME = "operator"

val scala2 = "2.13.6"
val scala3 = "3.0.0"

lazy val commonDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.2.9" % Test,
)

lazy val commonSettings = Seq(
  version := VERSION,
  organization := GROUP_ID,
  scalaVersion := scala3,
  semanticdbVersion := "4.4.18"
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
    crossScalaVersions := Seq(scala3, scala2)
  )
  .settings(Test / testOptions += Tests.Argument("-oI"))
  .settings(Test / testOptions += Tests.Argument(
    TestFrameworks.ScalaTest, "-u", {
      val dir = System.getenv("CI_REPORTS")
      if(dir == null) "target/reports" else dir
    })
  )

