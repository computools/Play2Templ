package model.database.dao

import anorm._
/**
 * Created for templ
 * User: Volk
 * Date: 23.11.2015
 * Time: 1:27

 */
abstract class BaseDao[A] {
   val parser : RowParser[A]
   val table:String
   val schema:String

//   def select( params: Seq[NamedParameter]):List[A] = {
//        val q = "select * from" + table + (if (params.isEmpty) {
//          ""
//        } else {
//          ""
//       //   " where" + params.map { case (col, _) => col + " = {" + col + "}" }
//        //    .mkString(" AND ")
//        })
//  //   SQL(q).on(params:_*).as(parser*)
//   }

}
