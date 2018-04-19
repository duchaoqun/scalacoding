package info.aoye.config

import com.typesafe.config.{Config, ConfigFactory}
import scala.collection.JavaConverters._

object TestConfig extends scala.App {

    val config: Config = ConfigFactory.parseString(
      """
        |input {
        |  hive {
        |    table = "e_base_info"
        |    columns = ["pripid","entname"]
        |  }
        |}
      """.stripMargin)

    //判断是否存在这个节点，有就返回true
    println(config.hasPath("input"))

    //Get config file Content
    println(config.getString("input.hive.table"))
    //获取配置列表
    println(config.getStringList("input.hive.columns"))

    val columnsList = config.getStringList("input.hive.columns") //java.util.ArrayList

    var column: String = ""

    //java 集合 转换成 scala集合
    val a = columnsList.asScala.toList.map(x => column += x + ",")
    println(column.dropRight(1))

    //默认配置信息，如果配置文件中没有配置这个项目，那么将默认配置添加上去
    //config.withFallback()

    val config1:Config = ConfigFactory.parseString(
      """
        |abc{
        |  bbb="222"
        |}
      """.stripMargin)

    val config2:Config = ConfigFactory.parseString(
      """
        |abc{
        |  aaa="112"
        |  bbb="223"
        |  ccc="334"
        |}
      """.stripMargin)
    //config1是用户配置，config2是默认配置，如果用户没有配置，就将config2中的内容添加到config1中，返回新的Config对象
    val config3:Config = config1.withFallback(config2)
  }
