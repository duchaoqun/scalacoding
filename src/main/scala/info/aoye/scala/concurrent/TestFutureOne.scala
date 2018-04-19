package info.aoye.scala.concurrent

import java.time._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object TestFutureOne extends scala.App {

  Future{
    Thread.sleep(10000)
    println("This is the future process!!" + LocalTime.now())
  }

  println(LocalTime.now())

  val a = Future{
    for (i <- 1 to 100){
      print("A")
      Thread.sleep(10)
    }
  }

  val b = Future{
    for (i <- 1 to 100){
      print("B")
      Thread.sleep(10)
    }
  }

  println(a)
  println(b)
}
