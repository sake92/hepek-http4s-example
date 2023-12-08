val Http4sVersion = "0.23.23"

lazy val root = (project in file("."))
  .settings(
    organization         := "ba.sake",
    name                 := "hepek-http4s-example",
    scalaVersion         := "3.3.1",
    Compile / run / fork := true,
    libraryDependencies ++= Seq(
      "org.http4s"          %% "http4s-ember-server" % Http4sVersion,
      "org.http4s"          %% "http4s-dsl"          % Http4sVersion,
      "ch.qos.logback"       % "logback-classic"     % "1.4.14",
      "org.fusesource.jansi" % "jansi"               % "1.8",
      "ba.sake"             %% "hepek-http4s"        % "0.21.0"
    )
  )
