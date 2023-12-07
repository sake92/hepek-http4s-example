package ba.sake.hepek.http4s_example

import cats.effect.IOApp

object Main extends IOApp.Simple:
  val run = HepekServer.run
