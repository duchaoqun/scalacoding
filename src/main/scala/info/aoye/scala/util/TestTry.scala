package info.aoye.scala.util

import scala.util.Try

object TestTry extends scala.App {
  println(Try(10 / 0))

}
