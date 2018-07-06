package info.aoye.basic.sys

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


  //使用系统代理
  System.setProperty("http.maxRedirects", "50")
  System.getProperties.setProperty("proxySet", "true")
  val ip = "127.0.0.1"
  System.getProperties.setProperty("http.proxyHost", ip)
  System.getProperties.setProperty("http.proxyPort", "1080")
}
