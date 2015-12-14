import model.service.UserService
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import support.Generator
import support.db.DbSpecification
/**
 * Created for templ
 * User: Volk
 * Date: 22.11.2015
 * Time: 2:53
 */
@RunWith(classOf[JUnitRunner])
class UserServiceSpec extends DbSpecification  {
  val userCount = 10
  val userBaseName = "user"
  "User" should {
    "be" in {
      val all = UserService.getAll
      all.length must equalTo(userCount)
    }

  }

  override def generate(): Unit ={
      Generator.Users.createUsers(userBaseName, userCount)
  }
}
