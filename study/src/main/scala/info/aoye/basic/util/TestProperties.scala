package info.aoye.basic.util

import scala.util.Properties

/**
  * 单例对象，直接获取系统参数的工具类
  */
object TestProperties extends scala.App {
  //获取当前用户目录，绝对路径
  println(Properties.userDir)  // /home/aoye/IdeaProjects/aoye
  //获取系统名称
  println(Properties.osName)
  //获取用户的主目录
  println(Properties.userHome)

}
