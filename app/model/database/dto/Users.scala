package model.database.dto;
/**
 * Created for templ
 * User: Volk
 * Date: 21.11.2015
 * Time: 0:06

 */
case class User(name:String,email:String,id:Long=0) extends Base(id) {
  def this(id:Long, user:User){
      this(user.name,user.email,id)
  }
}

