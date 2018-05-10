package info.aoye.scala.TestSlick

import info.aoye.scala.TestSlick.Tables._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import slick.jdbc.MySQLProfile.api._ //这个驱动包是必须导入的,否则会出现各种异常,不要导入错误的数据库驱动.

/**
  * 学习持久层 http://slick.lightbend.com/doc/3.2.3/gettingstarted.html
  * 1. 查询所返回的结果都是Vector[T]类型的.
  * 2. 当数据库已经创建好了,存在相关表的时候,可以自动生成Tables.scala;最后再Import这个生成的代码.
  * 3. 生产环境中注意使用try等方式来处理异常.
  */
object Main extends scala.App {

  //创建数据库连接对象
  //db有个run方法使用DBIOAction作为参数,返回Future类型的返回值
  val db = Database.forURL(
    url = "jdbc:mysql://node1:3306/aoye?useUnicode=true&characterEncoding=UTF-8&useSSL=false",
    driver = "com.mysql.jdbc.Driver",
    user = "root",
    password = "Rexen@123.com.cn")


  /**
    * 测试代码:通过城市id获取对应天气信息,使用高德地图的api
    *
    * @param cityCode 城市编码
    * @return 天气对象表
    */
  def getWeatherInfoRow(cityCode: String): GaodeWeatherinfoRow = {
    import play.api.libs.json._
    val api: String = "http://restapi.amap.com/v3/weather/weatherInfo?key=fe013c4555a63fa1a482e3a5938c316&city=" + cityCode
    println(api)
    val count: Int = (Json.parse(scala.io.Source.fromURL(api).mkString) \ "count").get.as[String].toInt
    //注意判断js是否可以取到内容.
    if (count>0){
      val js: JsValue = (Json.parse(scala.io.Source.fromURL(api).mkString) \ "lives" \ 0).get
      if(js.toString().length > 100) {
        GaodeWeatherinfoRow(
          1,
          Some((js \ "province").get.as[String]),
          Some((js \ "city").get.as[String]),
          Some((js \ "adcode").get.as[String]),
          Some((js \ "weather").get.as[String]),
          Some((js \ "temperature").get.as[String]),
          Some((js \ "winddirection").get.as[String]),
          Some((js \ "windpower").get.as[String]),
          Some((js \ "humidity").get.as[String]),
          Some((js \ "reporttime").get.as[String])
        )
      }else{
        GaodeWeatherinfoRow(
          1,
          Some(""),
          Some(""),
          Some(cityCode),
          Some(""),
          Some(""),
          Some(""),
          Some(""),
          Some(""),
          Some("")
        )
      }
    }else{
      GaodeWeatherinfoRow(
        1,
        Some(""),
        Some(""),
        Some(cityCode),
        Some(""),
        Some(""),
        Some(""),
        Some(""),
        Some(""),
        Some("")
      )
    }
  }

  /**
    * 测试代码:slick查询功能
    * 注意的是,slick的数据库操作是异步的,返回的是Future对象,需要用Await.result或者使用回调来得到结果.
    *
    * @return 所有查询的返回结果类型都是Vector[T]类型
    */
  def getRegionCode: Vector[String] = {
    //测试代码:定义Action
    //Tables类可以在最上面添加引用,此处省略即可.
    val queryAction1 = Tables.GaodeWeatherinfo.result //使用全路径
    val queryAction2 = Region.filter(_.regionCode === "220000").result //使用Where条件,等于
    //val queryAction3 = sql"""select REGION_CODE from region where REGION_CODE like '220%'""".as[(String)] //直接执行SQL语句
    val queryAction3 = sql"""select REGION_CODE from region""".as[(String)] //直接执行SQL语句

    //测试代码:执行Action
    Await.result(db.run(queryAction1).map(result => println(result)), Duration.Inf) //表对象Tables.GaodeWeatherinfo的结果集,Tables是通过表自动生成的代码
    Await.result(db.run(queryAction2).map(result => println(result)), Duration.Inf) //使用Where条件,等于
    Await.result(db.run(queryAction3).map(result => println(result)), Duration.Inf) //直接执行SQL语句

    //1. Slick的查询可以直接通过TableQuery操作，使用TableQuery提供的filter可以实现过滤操作，使用drop和take完成分页操作，使用sortBy完成排序操作。
    val res1 = Await.result(db.run(queryAction3).map(_.foreach { //返回的是一个结果集(Vector[T]对象?) 然后执行Vector的freach方法,处理每一行
      case (id, name) => println("id:" + id + " name:" + name)
    }), Duration.Inf)
    //2. 使用drop和take完成分页操作,使用sortBy完成排序操作 todo 这里需要研究一下.
    val res4 = Await.result(db.run(GaodeWeatherinfo.drop(1).take(2).sortBy(_.id.desc).result), Duration.Inf)
    //手动指定返回
    //val res6 = Await.result(db.run(queryAction3), Duration.Inf)
    //res6

    //代码块最后一个表达式表示返回
    Await.result(db.run(queryAction3), Duration.Inf)
  }


  /**
    * 测试代码:slick插入数据功能
    * 使用生成的Row对象,进行插入 += 相当于insert.
    * 使用生成的Row对象组成Seq集合,然后 ++=进行批量插入.
    */
  def insertWeatherInfo(): Unit = {
    //测试代码:定义Action
    //单条记录插入Action
    val insertAction1 = GaodeWeatherinfo += GaodeWeatherinfoRow(6, Some("吉林"), Some("长春市"), Some("220100"), Some("多云"), Some("18"), Some("东北"), Some("5"), Some("24"), Some("2018-05-08 17:00:00"))
    //多条记录插入Action
    val insertAction2 = GaodeWeatherinfo ++= Seq(
      GaodeWeatherinfoRow(6, Some("吉林"), Some("长春市"), Some("220100"), Some("多云"), Some("18"), Some("东北"), Some("5"), Some("24"), Some("2018-05-08 17:00:00")),
      GaodeWeatherinfoRow(6, Some("吉林"), Some("长春市"), Some("220100"), Some("多云"), Some("18"), Some("东北"), Some("5"), Some("24"), Some("2018-05-08 17:00:00"))
    )

    //拼接的Action,插入我们需要的数据
    val insertAction3 = GaodeWeatherinfo ++= getRegionCode.map(x => getWeatherInfoRow(x)).toSeq

    //执行Action
    db.run(insertAction3)
  }

  //测试代码:执行更新操作
  val new_row = GaodeWeatherinfoRow(6, Some("吉林"), Some("长春市"), Some("220100"), Some("多云"), Some("18"), Some("东北"), Some("5"), Some("24"), Some("2018-05-08 17:00:00"))
  val res4 = Await.result(db.run(GaodeWeatherinfo.filter(_.id === new_row.id).update(new_row)), Duration.Inf) // return effected row numbers

  //测试代码:执行删除操作
  val res5 = Await.result(db.run(GaodeWeatherinfo.filter(_.id === "999").delete), Duration.Inf)

  insertWeatherInfo()
  /*
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



    } finally db.close()
  */


  Thread.sleep(10000)
  db.close()
  //todo https://blog.csdn.net/hany3000/article/details/50507945
  //todo 如何直接使用SQL语句 http://wiki.jikexueyuan.com/project/slick-guide/schema.html

  /* todo 不存在表结构的情况,如何操作?
      //创建操作,如果表不存在,就创建一个?
    //DBIO是一个单例对象,它的seq方法可以传入多个DBIOAction,然后返回一个新的DBIOAction. += 方法返回的也是DBIOAction.
    val setup = DBIO.seq(
      (suppliers.schema).create, //创建表
      suppliers += (101, "1Acme, Inc") //插入初始值内容
    )
    //执行操作
    val setupFuture = db.run(setup)
  */
}
