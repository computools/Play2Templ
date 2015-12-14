package model.service

import model.database.dao.UsersDao
import model.database.dto.User

/**
 * Created for templ
 * User: Volk
 * Date: 21.11.2015
 * Time: 0:58

 */
object UserService {
     protected  val userDao : UsersDao = new UsersDao
     def getAll : List[User] = userDao.getAll
     def getById(id: Long):Option[User] = {
     //  userDao.byId(id)
       Option(null)
     }
     def insert(user:User):Option[User] = {
       Option(new User(userDao.insert(user).get,user))
     }
}

