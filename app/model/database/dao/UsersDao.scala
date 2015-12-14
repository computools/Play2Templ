package model.database.dao
import anorm.{SqlParser, SQL, SqlQuery}
import play.api.db.DB
import model.database.dto.User
import play.api.Play.current
/**
 * Created for templ
 * User: Volk
 * Date: 21.11.2015
 * Time: 0:52

 */
 class UsersDao {
  val userParser =  SqlParser.str("name") ~ SqlParser.str("email") map {
   item=> User(item._1, item._2)
  }
  val sql: SqlQuery = SQL("select * from users.users order by name asc")
  val insertQuery = "INSERT INTO users.users(name, email) VALUES({name}, {email})"
  val getByIdQuery = "select * from users.users where id ={id}"

  def getAll: List[User] = DB.withConnection { implicit connection =>
     sql.as(userParser*)
  }

  def insert(user:User): Option[Long] = DB.withConnection{ implicit connection =>
      SQL(insertQuery).on("name" -> user.name, "email" -> user.email).executeInsert(SqlParser.scalar[Long].singleOpt)
  }

  def getById(id:Long): Option[User] = DB.withConnection{ implicit connection =>
    SQL(getByIdQuery).on("id" -> id).as(userParser*).headOption
  }

}
