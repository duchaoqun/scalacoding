package info.aoye.jdbc


import java.lang.management.ManagementFactory
import java.sql.DriverManager


object UpdatePID extends scala.App {
  val strConn: String = "jdbc:mysql://node1:3306/app?user=root&password=Rexen@123.com.cn"
  val conn = DriverManager.getConnection(strConn)

  private def getPID:Int = {
    val info = ManagementFactory.getRuntimeMXBean.getName
    info.split("@")(0).toInt
  }

  /**
    * 更新任务列表的PID,获取当前程序的PID,然后更新到任务列表.
    * @param taskID 任务的ID
    */
  def update(taskID: Int): Unit = {
    try {
      val prep = conn.prepareStatement("UPDATE task_waterdrop SET PID=? where id=?")
      prep.setInt(2, taskID)
      prep.setInt(1, getPID)
      prep.executeUpdate()
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      println("Update PID OK!")
    }
  }
  conn.close()
}
