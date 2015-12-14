import model.database.dto.User
import org.specs2.mutable.Specification;

/**
 * Created for templ
 * User: Volk
 * Date: 22.11.2015
 * Time: 21:03
 */
class ScalaSimpleTest extends Specification {

  "User constructor" should {
    "work with id and previous object version" in {
      val user = new User("test", "test@test.test")
      val userWithId = new User(1, user)
      userWithId.id must equalTo(1)
      userWithId.name must equalTo("test")
      userWithId.email must equalTo("test@test.test")
    }
  }
}
