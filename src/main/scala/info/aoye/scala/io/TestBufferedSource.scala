package info.aoye.scala.io


import scala.collection.mutable.ListBuffer
import scala.io.{BufferedSource, Source}

/**
  * scala使用BufferedSource
  * 1. 缓冲器里面的内容输出后就没有了! 使用后就没有了!?
  */
object TestBufferedSource {
  val html: BufferedSource = Source.fromURL("http://www.duchaoqun.com")

  val listChar = new ListBuffer[Char]
  //将结果转换成Char 列表
  html.mkString.distinct.toList.foreach(c => listChar += c)  //输出之后,html里面就没有内容了.

}
