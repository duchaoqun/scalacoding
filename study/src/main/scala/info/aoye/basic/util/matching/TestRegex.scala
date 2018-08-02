package info.aoye.basic.util.matching

import scala.util.matching.Regex

/**
  * scala 正则表达式使用
  *
  * 1. 如果正则表达式包含反斜杠或引号的话,那么最好使用"原始"字符串语法
  * 2.
  */
object TestRegex extends scala.App {
  //使用String类的r()方法构造了一个Regex对象
  val pattern = "Scala".r
  val str = "Scala is Scalable and cool"

  //返回匹配的第一个内容,如下两个写法是一样的
  pattern findFirstIn str  //Some(Scala)
  pattern.findFirstIn(str)  //Some(Scala)

  //匹配字符+数字
  val pattern1 = new Regex("abl[ae]\\d+")
  val str1 = "ablaw is able123 and cool"

  println((pattern1 findAllIn str1).mkString(","))
  println((pattern1 findAllIn str1).getClass)  //class scala.util.matching.Regex$MatchIterator

  //匹配所有内容,findAllln方法返回遍历所有匹配项的迭代器,你可以在for循环中使用它
  val numPattern = """\d+""".r
  for ( matchString <- numPattern.findAllIn( "99 bottles, 98 bottles")){
    println(matchString)
  }


  //使用分组
  val pattern3 = """(\d+)/(\d+)""".r  //在模式中定义了两个组
  val str3 = "2018/08/232"
  for ( pattern3(one,two)<- pattern3.findAllIn(str3)){  //模式对象中保存的就是组中对应的内容, 如果上面只有一个组,这里也必须定义一个参数对象.
    println(one)
    println(two)
  }

  //todo   批评并替换  pattern1.replaceAllIn("dd")
}
