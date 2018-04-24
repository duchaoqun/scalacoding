package info.aoye.scala.util

import scala.util.Either
import java.net.URL


/**
  * scala api学习,Either处理异常.
  * Try 不能完全替代 Either，它只是 Either 用来处理异常的一个特殊用法。 Try 和 Either 互相补充，各自侧重于不同的使用场景。
  * http://wiki.jikexueyuan.com/project/guides-to-scala-book/chp7-the-either-type.html
  */
object TestEither extends scala.App {

  //案例1:定义方法,返回Either类型,方法包包括需要处理的异常信息.
  def getContent(url: URL): Either[String, String] = {
    if (url.getHost.contains("google")) {
      Left("?????")
    } else {
      Right("!!!")
    }
  }
  println(getContent(new URL("https://plus.google.com")))


}
