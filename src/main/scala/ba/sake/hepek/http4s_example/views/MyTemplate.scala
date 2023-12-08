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
        brandName = Some("Hepek - Http4s"),
        brandIconUrl = Some("https://http4s.org/images/http4s-favicon.svg"),
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
        right = List(Navbar.link("#", "Contact us"))
      ),
      pageContent
    )
