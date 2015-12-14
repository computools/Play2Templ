package controllers

import model.service.UserService
import play.api.mvc._

class Base extends Controller {
  def index = Action {
    val users = UserService.getAll
    Ok(views.html.index(users))
  }

  def test(from: Option[Int], to: Option[Int]) = Action {
   Ok("test")
  }
}
