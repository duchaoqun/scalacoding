package info.aoye.basic.util.control

import scala.util.control.Exception._
import scala.util.control.Exception.Catch
import java.net._

import scala.util.Try

object TestException extends scala.App {

  // 创建一个Catch对象，用来处理指定的异常
  // TODO:特定的异常都有那些？
  val s = "http://www.scala-org.org"

  // Some(http://www.scala-lang.org/)
  val x1: Option[URL] = catching(classOf[MalformedURLException]).opt(new URL(s))
  val x11: Option[URL] = catching(classOf[MalformedURLException]) opt (new URL(s)) //使用catching方法 组装 URL对象？

  // Right(http://www.scala-lang.org/)
  val x2: Either[Throwable, URL] = catching(classOf[MalformedURLException], classOf[NullPointerException]) either new URL(s)

  // Success(http://www.scala-lang.org/)
  val x3: Try[URL] = catching(classOf[MalformedURLException], classOf[NullPointerException]) withTry new URL(s)

  val defaultUrl = new URL("http://example.com")
  //  URL(http://example.com) because htt/xx throws MalformedURLException
  val x4: URL = failAsValue(classOf[MalformedURLException])(defaultUrl)(new URL("htt/xx"))

  // 创建一个函数，打印异常信息
  def log(t: Throwable): Unit = t.printStackTrace

  // handling 返回的是By类型对象。 By类型只有一个by函数，将接收的对象 通过一个函数转换成另外一个类型。k
  val withThrowableLogging: Catch[Unit] = handling(classOf[MalformedURLException]) by (log)

  def printUrl(url: String) : Unit = {
    val con = new URL(url) openConnection()
    val source = scala.io.Source.fromInputStream(con.getInputStream())
    source.getLines.foreach(println)
  }

  val badUrl = "htt/xx"
  // Prints stacktrace,
  //   java.net.MalformedURLException: no protocol: htt/xx
  //     at java.net.URL.(URL.java:586)
  withThrowableLogging { printUrl(badUrl) }

  val goodUrl = "http://www.scala-lang.org/"
  // Prints page content,
  //   <!DOCTYPE html>
  //   <html>
  withThrowableLogging { printUrl(goodUrl) }
}
