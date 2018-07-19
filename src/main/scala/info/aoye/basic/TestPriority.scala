package info.aoye.basic

import info.aoye.basic.TestClass2.content

/**
  * 优先级的一些记录
  */


object TestClass1{
  val content = "Scala"
}

object TestClass2{
  val content = "Java"
}

object TestPriority extends scala.App {
  import TestClass1._       //使用占位符的方式导入优先级比直接导入要低.
  import TestClass2.content //直接导入的优先级要高于使用占位符.

  val content = "I like Scala!" //当前作用域的优先级是最高的.
  println(content)
}
