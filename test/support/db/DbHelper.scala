package support.db

import play.api.db.Databases
import play.api.db.evolutions.Evolutions

/**
 * Created for templ
 * User: Volk
 * Date: 22.11.2015
 * Time: 14:36

 */
object DbHelper {
  object DbConfig {
    val driver = "org.postgresql.Driver"
    var name = "default"
    val ulr = "jdbc:postgresql://localhost/devTest"
    val login = "postgres"
    val password = "volk"
  }

  val database = Databases(
    driver = DbConfig.driver,
    url = DbConfig.ulr,
    name = DbConfig.name,
    config = Map(
      "user" -> DbConfig.login,
      "password" -> DbConfig.password,
      "hikaricp.connectionTestQuery"->"SELECT 1"
    )
  )

  def initDb {
    Evolutions.applyEvolutions(database)
  }
  def cleanAndCloseDb {
    Evolutions.cleanupEvolutions(database)
   // database.shutdown()
  }
  def testDatabase(options: Map[String, String] = Map.empty[String, String]): Map[String, String] = {
    Map(
      "db.default.driver" -> DbConfig.driver,
      "db.default.hikaricp.connectionTestQuery" -> "SELECT 1",
      "db.default.url" -> (DbConfig.ulr),
      "db.default.username" -> DbConfig.login,
      "db.default.password" -> DbConfig.password,
      "play.evolutions.enabled"->"false",
      "db.default.logStatements"->"true"
    )
  }
}
