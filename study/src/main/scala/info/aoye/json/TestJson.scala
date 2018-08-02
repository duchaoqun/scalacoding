package info.aoye.json

import net.liftweb.json._
import net.liftweb.json.JsonAST
import net.liftweb.json.JsonDSL._

/**
  * 如下两个参考文档
  * https://blog.csdn.net/leehbing/article/details/74391308
  * https://github.com/lift/framework/blob/master/core/json/README.md
  */
object TestJson extends scala.App {
  val json1 = ("foo" -> 4) ~ ("bar" -> "baz")
  val json2 = ("spark.streaming.batchDuration" -> 5)
  val json3 = ("spark.app.name" -> "Waterdrop")
  println(compactRender(json1))
  println(compactRender(json2))
  println(compactRender(json3 ~ json2))

  //创建一个json
  val str1 = (
    "spark" ->
      ("spark.streaming.batchDuration" -> 5)
        ~ ("spark.app.name" -> "Waterdrop")
        ~ ("spark.executor.instances" -> 2)
        ~ ("spark.executor.cores" -> 1)
        ~ ("spark.executor.memory" -> "1g")
        ~ ("other"-> List(1,2,3,4,5))
    )
  //解析成字符串
  println(compactRender(str1))

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
