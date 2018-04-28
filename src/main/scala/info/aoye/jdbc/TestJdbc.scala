package info.aoye.jdbc

import java.sql.{Connection, DriverManager, ResultSet}
import java.util.Properties

object TestJdbc extends scala.App {
  //获取项目内配置文件
  val config = new Properties()
  //TODO:这个内容需要学习一下
  //注意：后面的配置上有一个斜杠
  val config_file = this.getClass.getResourceAsStream("/jdbc.properties")

  config.load(config_file)

  val str_jdbc = config.getProperty("JDBC")
  val str_username = config.getProperty("USERNAME")
  val str_password = config.getProperty("PASSWORD")
  val str_database = config.getProperty("DATABASE")


  val str_conn = str_jdbc + "/" + str_database + "?user=" + str_username + "&password=" + str_password

  println(str_conn)


  // 加载驱动，在当前类中加载驱动类，貌似是非必须的
  //classOf[com.mysql.jdbc.Driver]

  // 创建链接
  val conn = DriverManager.getConnection(str_conn)


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
  //TODO：需要实际搞一搞
  //    try {
  //      val prep = JDBC.getConn.prepareStatement("INSERT INTO quotes (quote, author) VALUES (?, ?) ")
  //      prep.setString(1, "Nothing great was ever achieved without enthusiasm.")
  //      prep.setString(2, "Ralph Waldo Emerson")
  //      prep.executeUpdate
  //    } catch{
  //      case e:Exception =>e.printStackTrace
  //    }
  //    finally {
  //      JDBC.closeConn
  //    }

  //todo: 如果执行类是一个伴生对象,那么这个连接会持续到什么时候? 程序退出在释放吗?
  conn.close()

  //todo:ResultSets对象转换成Object,封装代码进行解耦合.
}
