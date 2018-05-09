package info.aoye.jdbc

import java.sql.{Connection, DriverManager, ResultSet}
import java.util.Properties

import com.typesafe.scalalogging._

class DBTools extends LazyLogging {
  def getConfig: String = {
    val config: Properties = new Properties()
    val configFile = this.getClass.getResourceAsStream("jdbc.properties")
    config.load(configFile)
    val str_jdbc = config.getProperty("JDBC")
    val str_username = config.getProperty("USERNAME")
    val str_password = config.getProperty("PASSWORD")
    val str_database = config.getProperty("DATABASE")
    val charsetEncoding = config.getProperty("characterEncoding")
    val useSSL = config.getProperty("useSSL")
    val str_conn = str_jdbc + "/" + str_database + "?user=" + str_username + "&password=" + str_password + "&characterEncoding=" + charsetEncoding + "&useSSL=" + useSSL
    logger.info("Prepare JDBC info: " + str_conn)
    str_conn
  }

  def getConn: Connection = {
    logger.info("Get JDBC Conn: Success!")
    DriverManager.getConnection(getConfig)
  }

  def closeConn(conn: Connection): Unit = {
    logger.info("Close JDBC.")
    conn.close
  }

  def insertObj[T](sql: String, obj: T, conn: Connection): Unit = {
    try {
      val prep = conn.prepareStatement("insert into gaode_weatherinfo(province,city,adcode,weather,temperature,winddirection,windpower,humidity,reporttime) values(?,?,?,?,?,?,?,?,?)")

      prep.executeUpdate()
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      println("OK")
    }
  }

  def deleteObj(): Unit = {

  }

  def updateObj(): Unit = {

  }

  def selectObj(sql: String, conn: Connection): ResultSet = {
    val prep = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    val rs = prep.executeQuery(sql)
    rs
  }
}
