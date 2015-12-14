package controllers

/**
 * Created for templ
 * User: Volk
 * Date: 21.11.2015
 * Time: 3:19

 */
object MainTest {

  def main(args: Array[String]) ={
               a{
                 println("qq")
               }
  }

  def a(block: =>Unit) = {println("befor");block;println("end")}
}
