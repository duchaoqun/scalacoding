package info.aoye.scala.sys

import scala.sys.SystemProperties

/**
  * 获取系统参数
  * 对应Java的如下内容
  * val a = java.lang.System.getProperties
  * println(a.getProperty("user.dir"))
  */
object TestSystemProperties extends scala.App {
  //创建系统参数对象，可以操作系统参数？
  val pp = new SystemProperties
  //获取系统参数，内容是一个Map对象，get的结果是Some对象
  println(pp.get("user.dir"))

}
