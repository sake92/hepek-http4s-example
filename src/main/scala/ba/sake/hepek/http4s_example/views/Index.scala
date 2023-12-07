package ba.sake.hepek.http4s_example.views

import Bundle.*, Tags.*

object Index extends MyTemplate:

  override def pageSettings = super.pageSettings
    .withTitle("Http4s Hepek")

  override def pageContent = Grid.row(
    s"""
      ## Welcome
      Some content..
      - one
      - two
      - test
    """.md,
    a(href := "/showForm", Classes.btnClass, Classes.btnPrimary)(
      "Customer form"
    )
  )
