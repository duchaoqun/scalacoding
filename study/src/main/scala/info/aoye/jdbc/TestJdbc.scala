package info.aoye.jdbc

import java.sql.{Connection, DriverManager, ResultSet}
import java.util.Properties

/**
  * scala使用JDBC操作数据库
  */
object TestJdbc extends scala.App {
  //获取项目内配置文件
  val config = new Properties()
  //TODO:这个内容需要学习一下
  val config_file = this.getClass.getResourceAsStream("/jdbc.properties")  //注意：后面的配置上有一个斜杠
  config.load(config_file)
  val str_jdbc = config.getProperty("JDBC")
  val str_username = config.getProperty("USERNAME")
  val str_password = config.getProperty("PASSWORD")
  val str_database = config.getProperty("DATABASE")
  val str_conn = str_jdbc + "/" + str_database + "?user=" + str_username + "&password=" + str_password

  //获取项目内配置文件
  def getConfig:String = {
    val config:Properties = new Properties()
    val configFile = this.getClass.getResourceAsStream("jdbc.properties")
    config.load(configFile)
    val str_jdbc = config.getProperty("JDBC")
    val str_username = config.getProperty("USERNAME")
    val str_password = config.getProperty("PASSWORD")
    val str_database = config.getProperty("DATABASE")
    val charsetEncoding = config.getProperty("characterEncoding")
    val str_conn = str_jdbc + "/" + str_database + "?user=" + str_username + "&password=" + str_password +"&characterEncoding=" + charsetEncoding

    str_conn
  }

  // 加载驱动，在当前类中加载驱动类，貌似是非必须的
  //classOf[com.mysql.jdbc.Driver]

  // 创建链接
  val conn = DriverManager.getConnection(str_conn)
  def getConn(jdbcStr:String):Connection={
    DriverManager.getConnection(jdbcStr)
  }
  def closeConn(conn:Connection):Unit={
    conn.close
  }

  //执行查询语句
  try {
    // 准备查询语句
    val statment = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    // 执行SQL语句
    val rs = statment.executeQuery("select * from conf_jdbc")
    // rs维护一个指针，指向第一条记录，如果有数据next返回true
    // 如果不移动指针,会曝出 "Before start of result set" 的错误.
    while (rs.next()) {
      // 获取当前数据行的记录值，注意类型
      val id = rs.getInt(1)
      val jdbc = rs.getString(2)
      val username = rs.getString(3)
      val password = rs.getString(4)
      val database = "-1"
      // 也可以使用表字段名称
      //rs.getString("column name")
    }
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    println("Get JDBC OK.")
  }


  //执行插入语句
/*  def insertObj(obj:GaoDeWeatherInfo,conn:Connection) = {
    try{
      val prep = conn.prepareStatement("insert into gaode_weatherinfo(province,city,adcode,weather,temperature,winddirection,windpower,humidity,reporttime) values(?,?,?,?,?,?,?,?,?)")
      prep.setString(1,obj.province)
      prep.setString(2,obj.city)
      prep.setString(3,obj.adcode)
      prep.setString(4,obj.weather)
      prep.setString(5,obj.temperature)
      prep.setString(6,obj.winddirection)
      prep.setString(7,obj.windpower)
      prep.setString(8,obj.humidity)
      prep.setString(9,obj.reporttime)

      prep.executeUpdate()
    }catch{
      case e:Exception => e.printStackTrace()
    } finally {
      println("OK")
    }
  }*/

  //todo: 如果执行类是一个伴生对象,那么这个连接会持续到什么时候? 程序退出在释放吗?
  conn.close()

  //todo:ResultSets对象转换成Object,封装代码进行解耦合.
}
