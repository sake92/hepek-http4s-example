package ba.sake.hepek.http4s_example.models

case class Hero(name: String):
  def key = name.toLowerCase.replace(" ", "-")

object Hero:
  val All = List(Hero("Batman"), Hero("Superman"))
