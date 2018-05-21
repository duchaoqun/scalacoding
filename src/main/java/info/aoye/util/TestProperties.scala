package info.aoye.util

import java.io.FileInputStream
import java.util.Properties

/**
  * 我们使用Java的工具类实现获取配置文件
  */
object TestProperties extends scala.App {

  //创建配置文件对象
  val properties = new Properties()
  //获取项目中的配置文件路径
  val currentPath = Thread.currentThread().getContextClassLoader.getResource("jdbc.properties").getPath
  //加载配置文件到对象
  properties.load(new FileInputStream(currentPath))
  //获取配置文件里面的内容，如果没有前面的key，就返回后面的Null
  properties.getProperty("abc","Null")
  properties.getProperty("abd","Null")
  //可以给对象添加配置
  properties.setProperty("ddd","123")


  /*
  * 如果发布工程，需要加载外部配置文件，需要准确的获取配置文件位置
  * 1、使用相对路径获取配置，先获取程序路径，然后获取配置文件路径，拼接配置文件
  * 2、使用命令行参数加载配置文件
  */
  //Java 获取当前程序目录
  val prop1 = java.lang.System.getProperties
  println(prop1.getProperty("user.dir"))
  //Scala 获取当前程序目录
  val prop2 = scala.util.Properties
  println(prop2.userDir)

  //拼接配置文件路径，然后在获取配置文件内容即可。
  val path1 = prop2.userDir+"/conf/test.properties"
  println(path1)
}
