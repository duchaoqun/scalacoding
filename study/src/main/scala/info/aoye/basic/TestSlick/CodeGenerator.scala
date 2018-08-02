package info.aoye.basic.TestSlick

import java.util.concurrent.TimeUnit
import slick.codegen.SourceCodeGenerator
import slick.jdbc.MySQLProfile
import slick.jdbc.MySQLProfile.api._
import slick.driver.MySQLDriver
import slick.jdbc.meta.MTable

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * 在动生成
  */
object CodeGenerator extends scala.App {
  val slickDriver = "slick.jdbc.MySQLProfile"  //留意过时的名字
  val jdbcDriver = "com.mysql.jdbc.Driver"     //JDBC 驱动名字
  val url = "jdbc:mysql://node1/aoye"         //JDBC URL
  val outputDir = "C://"      //输出路径
  val pkg = "info.aoye"      //包名称,跟随输出路径
  val username = "root"
  val password = "Rexen@123.com.cn"

  //官方样例,最简单的生成内容
  slick.codegen.SourceCodeGenerator.main(
    Array(slickDriver, jdbcDriver, url, outputDir, pkg, username, password)
  )

  /* todo 需要学习的内容
    val db = Database.forURL(url,username,password)

    val dbio = MySQLProfile.createModel(Some(MTable.getTables(None, None, None, Some(Seq("TABLE", "VIEW")))))
    val model = db.run(dbio)
    val future : Future[SourceCodeGenerator] = model.map(model => new SourceCodeGenerator(model))
    val codegen : SourceCodeGenerator = Await.result(future, Duration.create(5, TimeUnit.MINUTES))
    codegen.writeToFile(slickDriver, outputDir, pkg, "Tables", "Tables.scala")
  */


}
