package info.aoye.scala.TestSlick

import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import slick.jdbc.H2Profile.api._
import info.aoye.scala.TestSlick.Tables

/**
  * 学习持久层 http://slick.lightbend.com/doc/3.2.3/gettingstarted.html
  */
object Main extends scala.App {

  //创建数据库连接对象
  //db有个run方法使用DBIOAction作为参数,返回Future类型的返回值
  val db = Database.forURL(
    url = "jdbc:mysql://node1:3306/aoye?useUnicode=true&characterEncoding=UTF-8&useSSL=false",
    driver = "com.mysql.jdbc.Driver",
    user = "root",
    password = "Rexen@123.com.cn")

  //存在表结构的情况,使用表结构自动generaterater
  try {
    //表对象Tables.GaodeWeatherinfo的结果集
    Await.result(db.run(Tables.GaodeWeatherinfo.result).map(result => println(result)),Duration.Inf)

    //创建操作,如果表不存在,就创建一个?
    //DBIO是一个单例对象,它的seq方法可以传入多个DBIOAction,然后返回一个新的DBIOAction. += 方法返回的也是DBIOAction.


    //新增
    val insertAction: DBIO[Option[Int]] = suppliers ++= Seq(
      (1, "format1"),
      (2, "format2"),
      (3, "format3")
    )
    val insertAndPrintAction = insertAction.map { studentResult => //todo 这个是什么逻辑?
      studentResult.foreach { numRows =>
        println(s"inserted $numRows students")
      }
    }
    db.run(insertAndPrintAction)

    //删除

    //修改

    //查询操作
    //1. Slick的查询可以直接通过TableQuery操作，使用TableQuery提供的filter可以实现过滤操作，使用drop和take完成分页操作，使用sortBy完成排序操作。
    val res2 = Await.result(db.run(suppliers.result).map(_.foreach { //返回的是一个结果集(难道只有一个对象?) 然后遍历结果集,处理每一行.
      case (id, name) => println("id:" + id + " name:" + name)
    }), Duration.Inf)
    //2. 使用filter实现where条件过滤.
    val res3 = Await.result(db.run(suppliers.filter(_.id > 10.toLong).filter(_.id < 12.toLong).result).map(_.foreach { //返回的是一个结果集(难道只有一个对象?) 然后遍历结果集,处理每一行.
      case (id, name) => println("id1:" + id + " name1:" + name)
    }), Duration.Inf)
    //3. 使用drop和take完成分页操作,使用sortBy完成排序操作
    val res4 = Await.result(db.run(suppliers.drop(1).take(2).sortBy(_.id.desc).result).map(_.foreach { //返回的是一个结果集(难道只有一个对象?) 然后遍历结果集,处理每一行.
      case (id, name) => println("id2:" + id + " name2:" + name)
    }), Duration.Inf)

  } finally db.close()


  Thread.sleep(10000)
  //todo https://blog.csdn.net/hany3000/article/details/50507945
  //todo 如何直接使用SQL语句 http://wiki.jikexueyuan.com/project/slick-guide/schema.html

  /* todo 不存在表结构的情况,如何操作?
    val setup = DBIO.seq(
      (suppliers.schema).create, //创建表
      suppliers += (101, "1Acme, Inc") //插入初始值内容
    )
    //执行操作
    val setupFuture = db.run(setup)
  */
}
