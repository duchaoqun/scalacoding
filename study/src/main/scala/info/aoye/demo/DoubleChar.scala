package info.aoye.demo

import scala.collection.mutable.ListBuffer

/**
  * 获取两个字符的列表
  * @param str 需要切分的字符串
  */
class DoubleChar(var str: String) {
  var contextList = new ListBuffer[String]
  println(str.length)
  println(str.last)

  while (str.length > 0) {
    //    println(str1.take(2))
    contextList += str.take(2)
    str = str.drop(1)
  }

  override def toString: String = contextList.toList.toString()
}

object DoubleChar {
  def apply(str: String): DoubleChar = new DoubleChar(str)

}
