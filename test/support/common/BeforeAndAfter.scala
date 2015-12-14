package support.common

import org.specs2.mutable.Specification
import org.specs2.specification.core.Fragments


/**
 * Created for templ
 * User: Volk
 * Date: 22.11.2015
 * Time: 20:09

 */
abstract class BeforeAndAfter extends Specification {
  override def map(fragments: =>Fragments) = step(beforeAll) ^ fragments ^ step(afterAll)
  protected def beforeAll()
  protected def afterAll()

}
