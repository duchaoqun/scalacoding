package info.aoye.basic.collection.mutable

object TestStringBuilder extends scala.App {
  val strbd1 = new StringBuilder

  //添加单个字符
  strbd1 += 'a'

  //添加多个字符
  strbd1 ++= "bcdef"

  //转换成字符串
  println(strbd1.toString())

}
