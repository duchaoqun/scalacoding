package info.aoye.config

import java.io.File

import com.typesafe.config._

import scala.collection.JavaConverters._

/**
  * 创建配置文件对象
  */
object TestConfigFactory extends scala.App {
  // ConfigFactory，创建Config对象。
  // 创建一个空的Config对象
  val configfactory: Config = ConfigFactory.empty()

  // 创建一个Config对象，从文件读取
  val configfactory1: Config = ConfigFactory.parseFile(new File("/opt/etc/test.conf"))

  // 创建一个Config对象，从字符串获取内容
  val configFactory2: Config = ConfigFactory.parseString("""abc.def{name=["ddd","ddd"]}""")

  // 从字符串获取配置信息
  val config: Config = ConfigFactory.parseString(
    """
      |spark{
      |  aaa{
      |    a1:"2",
      |    a3:"3"
      |  }
      |  bbb{
      |    b1="1"
      |    b2="2"
      |    b3="3"
      |  }
      |}
      |
      |input {
      |  fake {
      |    asdf="1231"
      |  }
      |}
      |output.to{
      | aaa=["asdf"]
      |}
    """.stripMargin)

  // 验证配置信息是否正确
  config.checkValid(ConfigFactory.defaultReference(), "simple-lib")
  // 判断config对象是否为空
  if (config.isEmpty) println("config file is null!")

  // 取出所有内容
  val config0 = config.root()
  // 取出Config对象的分支内容
  val config1 = config.getConfig("spark").root()
  // 取出Config对象中的一个列表值
  // 注意: 这里的指是Java的ArrayList对象
  // 需要在上面引入 scala.collection.JavaConverters._ 来转换成Scala集合类型
  val config2 = config.getStringList("output.to.aaa")
  // val a = config2.asScala.toList.map(_ += ",")

  // 在一个Config对象中添加内容
  val configNew: Config = configfactory.withValue("sparkd", config.getConfig("spark").root())


  // 向一个Config对象里面添加值,这里会自动根据句号分割!!
  val config3: Config = ConfigFactory.empty()
  val config4: Config = config3
    .withValue("spark.streaming.batchDuration", ConfigValueFactory.fromAnyRef("5"))
    .withValue("dish.name", ConfigValueFactory.fromAnyRef("SomeCompany"))
    .withValue("dish.estimatedCost", ConfigValueFactory.fromAnyRef(10))

  // 设置一个Key?
  val config5: Config = config3.atKey("spark.streaming.batchDuration")




  //  spark {
  //    # Waterdrop defined streaming batch duration in seconds
  //    spark.streaming.batchDuration = 5
  //
  //    # see available properties defined by spark: https://spark.apache.org/docs/latest/configuration.html#available-properties
  //    spark.app.name = "Waterdrop"
  //    spark.executor.instances = 2
  //    spark.executor.cores = 1
  //    spark.executor.memory = "1g"
  //  }
}