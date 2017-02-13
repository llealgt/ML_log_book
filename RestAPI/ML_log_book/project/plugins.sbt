// The Typesafe repository
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/maven-releases/"

// Typesafe snapshots
resolvers += "Typesafe Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.10")

//eclipse plugin
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.0.1")
