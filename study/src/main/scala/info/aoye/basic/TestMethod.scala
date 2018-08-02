package info.aoye.basic

/**
  * 使用方法
  */
object TestMethod extends scala.App {
  //todo 这个需要复习复习
  //def flatMap[B](f: (A) ⇒ GenTraversableOnce[B]): Array[B]
  //将一个函数应用于数组中的每一个元素，并使用结果集合构建一个新的集合。
  def getWords(lines: Seq[String]): Seq[String] = {
    lines flatMap (line => line split "\\W+")
  }
}
