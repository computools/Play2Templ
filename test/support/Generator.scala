package support

import model.database.dto.User
import model.service.UserService

/**
 * Created for templ
 * User: Volk
 * Date: 22.11.2015
 * Time: 20:02

 */
object Generator {
    object Users{
      val emailDomain = "test.com"
      def user(name:String):User  = new User(name,(name+"@"+emailDomain))
      def createUser(name: String): User = UserService.insert(user(name)).get
      def createUsers(baseName: String, count: Int): List[User] =
        (for(i <- 1 to count) yield createUser((baseName+i))).toList
    }

}
