package info.aoye.demo

import scala.io.{BufferedSource, Source}

object Main extends scala.App {

  val html: BufferedSource = Source.fromURL("http://www.duchaoqun.com")

  println(html.mkString)
  val str:String = """    <meta http-equiv="Cache-Control" content="no-siteapp"/>    <title>平凡之路</title>
                     |    <meta name="keywords" content="duchaoqun,aoye,bigdata,scala,java,hadoop" />"""

  val part = "<.*?>".r

  println(part.findAllIn(str).toList)
}
