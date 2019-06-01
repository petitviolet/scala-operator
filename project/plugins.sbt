resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.2")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.0")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.0-RC2")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.7")