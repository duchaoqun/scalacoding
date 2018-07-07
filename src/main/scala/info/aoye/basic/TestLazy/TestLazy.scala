package info.aoye.basic.TestLazy

/**
  * lazy 当开始用的时候才会被实例化
  */
object TestLazy extends scala.App {
  lazy val score = 100
  println(score)
}
