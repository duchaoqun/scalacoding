package info.aoye.jdbc

import java.lang.management.ManagementFactory
import java.sql.{Connection, DriverManager, ResultSet}


object TestRadonDB extends scala.App {
  val strConn: String = "jdbc:mysql://172.17.2.21:3308/radon1?user=root&password=Rexen@123.com.cn"
  val conn = DriverManager.getConnection(strConn)

  def selectObj(sql: String, conn: Connection): ResultSet = {
    val prep = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    val rs = prep.executeQuery(sql)
    rs
  }

  val result1 = selectObj("select count(*) as aaa from region",conn)
  while (result1.next()) {
    println(result1.getString("aaa"))
  }
  conn.close()
}
