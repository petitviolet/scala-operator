val VERSION = "0.1.0"

val GROUP_ID = "net.petitviolet"

val PROJECT_NAME = "operator"

val SCALA_VERSION = "2.12.1"

lazy val commonDependencies = Seq()

def commonSettings(projectName: String) = Seq(
  name := projectName,
  scalaVersion := SCALA_VERSION,
  version := VERSION,
  libraryDependencies ++= commonDependencies,
  organization := GROUP_ID
)


lazy val root = (project in file("."))
  .settings(name := "root")
  .aggregate(example, operator)

lazy val example = (project in file("example"))
  .settings(commonSettings("example"))
//  .settings(libraryDependencies += GROUP_ID %% PROJECT_NAME % VERSION)
  .dependsOn(operator)

lazy val operator = (project in file(PROJECT_NAME))
  .settings(commonSettings(PROJECT_NAME))
  .settings(testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", {val dir = System.getenv("CI_REPORTS"); if(dir == null) "target/reports" else dir} ))
  .settings(testOptions in Test += Tests.Argument("-oI"))
        