package ba.sake.hepek.http4s_example.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import cats.syntax.all.*
import org.http4s.FormDataDecoder.{given, *}
import org.http4s.FormDataDecoder
import org.http4s.QueryParamDecoder

case class CreateCustomer(
    email: String,
    password: String,
    dob: LocalDate,
    favoriteSuperHero: String
    // animals: List[String]
)

object CreateCustomer:

  val empty = CreateCustomer("", "", LocalDate.now, "")

  given QueryParamDecoder[LocalDate] =
    QueryParamDecoder.localDate(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

  given FormDataDecoder[CreateCustomer] = (
    field[String]("email"),
    field[String]("password"),
    field[LocalDate]("dob"),
    field[String]("favoriteSuperHero")
    // TODO ?? list[String]("animals")
  ).mapN(CreateCustomer.apply)
