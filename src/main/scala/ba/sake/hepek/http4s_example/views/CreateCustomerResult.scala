package ba.sake.hepek.http4s_example.views

import ba.sake.hepek.http4s_example.models.*
import Bundle.*, Tags.*

class CreateCustomerResult(formData: CreateCustomer) extends MyTemplate {

  override def pageSettings =
    super.pageSettings.withTitle("Customer form success!")

  override def pageContent = Grid.row(
    h2("Customer data result"),
    s"""
    Successfully submitted Customer data:

    ${formData}
    """.md
  )

}
