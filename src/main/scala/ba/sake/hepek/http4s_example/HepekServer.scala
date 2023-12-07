package ba.sake.hepek.http4s_example

import cats.effect.IO
import com.comcast.ip4s.*
import fs2.io.net.Network
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits.*

object HepekServer:

  def run: IO[Nothing] = {
    val httpApp = (
      HepekRoutes.routes[IO]()
    ).orNotFound
    for {
      _ <-
        EmberServerBuilder
          .default[IO]
          .withHost(ipv4"0.0.0.0")
          .withPort(port"8080")
          .withHttpApp(httpApp)
          .build
    } yield ()
  }.useForever
