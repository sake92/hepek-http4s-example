package ba.sake.hepek.http4s_example.views

import ba.sake.hepek.http4s_example.models.*
import Bundle.*, Tags.*

class CreateCustomerView() extends MyTemplate {

  override def pageSettings =
    super.pageSettings.withTitle("Customer form")

  override def pageContent = Grid.row(
    h2("Customer form"),
    formFrag
  )

  def formFrag =
    Form.form(action := "/submitForm", method := "POST")(
      Form.formFieldset("Customer data:")(
        Form.inputEmail(autofocus)("email", "Email"),
        Form.inputPassword()("password", "Password"),
        Form.inputDate()("dob", "Date of birth")
      ),
      Form.formFieldset("Preferences:")(
        Form.inputRadio(
          "favoriteSuperHero",
          Hero.All.map(h => (h.key, h.name, Nil)),
          "Super hero",
          _checkedValue = Hero.All.head.key,
          _isInline = false
        )
      ),
      Form.inputSubmit(Classes.btnPrimary)("Submit")
    )
}
