package support.db

import play.api.Play
import play.api.test.FakeApplication
import support.common.BeforeAndAfter

/**
 * Created for templ
 * User: Volk
 * Date: 22.11.2015
 * Time: 20:13

 */
abstract class DbSpecification extends BeforeAndAfter {
  val fakeApplication = FakeApplication(additionalConfiguration = DbHelper.testDatabase())
  sequential
  lazy val app : FakeApplication = {
    fakeApplication
  }
  def generate() ={}
  def beforeAll() {
    DbHelper.initDb
    Play.start(app)
    generate()
  }

  def afterAll() {
    Play.stop(app)
    DbHelper.cleanAndCloseDb
  }
}
