package info.aoye.java.lang.management

import java.lang.management.ManagementFactory

/**
  *
  */
object TestSystemThread extends scala.App {
  // 获取当前执行程序的PID和当前用户
  val PID: String = ManagementFactory.getRuntimeMXBean.getName
  println(PID)  //24149@aoye   PID 和 当前用户
  val currentPID = PID.split("@")(0)
  val currentUser = PID.split("@")(1)

}