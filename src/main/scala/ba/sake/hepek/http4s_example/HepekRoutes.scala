package ba.sake.hepek.http4s_example

import cats.effect.{Async, Concurrent}
import cats.syntax.all.*
import org.http4s.HttpRoutes
import org.http4s.StaticFile
import org.http4s.dsl.Http4sDsl
import org.http4s.FormDataDecoder.formEntityDecoder
import ba.sake.hepek.http4s.given
import ba.sake.hepek.http4s_example.models.CreateCustomer
import ba.sake.hepek.http4s_example.views.*
import org.http4s.InvalidMessageBodyFailure

object HepekRoutes:

  def routes[F[_]: Async: Concurrent](): HttpRoutes[F] =
    val dsl = new Http4sDsl[F] {}
    import dsl.*
    HttpRoutes.of[F] {

      case req @ GET -> "static" /: path =>
        StaticFile.fromResource(s"public/${path}", Some(req)).getOrElseF(NotFound())

      case GET -> Root =>
        Ok(Index)

      case GET -> Root / "showForm" =>
        Ok(CreateCustomerView())

      case req @ POST -> Root / "submitForm" =>
        req
          .as[CreateCustomer]
          .flatMap { entity =>
            Ok(CreateCustomerResult(entity))
          }
          .handleErrorWith { case e: InvalidMessageBodyFailure =>
            BadRequest(e.message)
          }
    }
