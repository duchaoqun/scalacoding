package info.aoye.basic.io

import scala.io.Source

object TestSource extends scala.App {

  //获取网页内容
  val html = Source.fromURL("https://www.baidu.com/") //返回BufferedSource
  html.foreach(println(_))  //循环输出,第一个_代表第一个参数,第二个_代表第二个参数.
  //从文件读取内容
  val aaa = Source.fromFile("/tmp/test.txt").mkString

  //TODO scala 的序列化和反序列化?? https://www.jianshu.com/p/080f18900f62
  //TODO 内存序列化? 磁盘序列化? 网络序列化?
}
