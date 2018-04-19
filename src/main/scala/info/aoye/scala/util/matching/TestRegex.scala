package info.aoye.scala.util.matching

import scala.util.matching.Regex

object TestRegex extends scala.App {
  //使用String类的r()方法构造了一个Regex对象
  val pattern = "Scala".r
  val str = "Scala is Scalable and cool"

  //匹配第一个字符,返回Some(Scala)
  println(pattern findFirstIn str)
  println(pattern.findFirstIn(str))

  //匹配字符+数字
  val pattern1 = new Regex("abl[ae]\\d+")
  val str1 = "ablaw is able123 and cool"

  println((pattern1 findAllIn str1).mkString(","))
  println((pattern1 findAllIn str1).getClass)  //class scala.util.matching.Regex$MatchIterator
}
