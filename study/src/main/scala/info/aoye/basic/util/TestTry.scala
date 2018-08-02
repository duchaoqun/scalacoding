package info.aoye.basic.util

import scala.io.StdIn
import scala.util.{Try, Success, Failure}

/**
  * scala Try对象学习.
  * Try 处理异常,与Either功能互补,都有各自的特点.
  */
object TestTry extends scala.App {

  //举例1:使用简单的计算
  //定义Try对象,declaration of Try object! 返回
  val res1 = Try(10 / 0) //class scala.util.Failure
  val res2 = Try(10 / 2) //class scala.util.Success

  println("res1对象的类型是:" + res1.getClass) //Exception in thread "main" java.lang.ArithmeticException: / by zero
  println("res1对象的内容是:" + res2.get) //5

  //结果获取和处理.
  res1 match {
    case Success(v) => println("直接打印Success对象包含的值:" + v) //打印Try里面的返回值.
    case Failure(e) => println("直接打印Failure对象中错误值:" + e.getMessage) /// by zero
  }


  //举例2:使用简单的方法
  def method1: String = {
    "这里是method1!!"
  }

  val res3 = Try(method1) match {
    case Success(v) => v
    case Failure(e) => println(e.getMessage)
  }
  println(res3)


  //举例3:更有效的方法,直接返回Try[T]类型,直接使用
  def method2: Try[String] = {
    Try("这里是method2!")
  }

  def method3(x: Int, y: Int): Try[Int] = {
    Try(x / y)
  }

  println(method2.getOrElse("Failure!")) //使用Try对象的getOrElse方法,如果是Success类型,返回内容.
  println(method3(10, 0).getOrElse("Failure!")) //使用Try对象的getOrElse方法,如果是Failure类型,返回指定内容.

  method3(10, 2) match { //调用然后直接获取对象.
    case Success(value) => println(value)
    case Failure(exception) => println(exception.getMessage)
  }

}
