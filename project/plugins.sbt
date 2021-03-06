logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.9")

addSbtPlugin("io.teamscala.sbt" % "sbt-babel" % "1.0.1")

addSbtPlugin("net.litola" % "play-sass" % "0.4.0")
