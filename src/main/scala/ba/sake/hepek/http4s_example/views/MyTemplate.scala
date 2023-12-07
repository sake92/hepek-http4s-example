package ba.sake.hepek.http4s_example.views

import Bundle.*, Tags.*, Classes.*

trait MyTemplate extends Page:

  override def bootstrapSettings =
    super.bootstrapSettings.withDepsProvider(DependencyProvider.cdnjs)

  override def styleURLs = super.styleURLs.appended("/static/styles/main.css")

  override def bodyContent =
    div(clsContainer)(
      Navbar.nav(
        brandUrl = "/",
        brandName = Some("My Company Ltd."),
        brandIconUrl = Some("https://img.icons8.com/color/48/000000/company.png"),
        left = List(
          Navbar.link("/showForm", "Form"),
          Navbar.dropdown(
            "Nested links",
            List(
              Navbar.dropdownLink("#", "Nested1"),
              Navbar.dropdownLink("#", "Nested2")
            )
          )
        ),
        right = List(a(href := "#")("Contact us"))
      ),
      pageContent
    )
