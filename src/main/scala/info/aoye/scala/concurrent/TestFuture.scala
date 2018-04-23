package info.aoye.scala.concurrent

import java.util.concurrent.{Callable, ExecutorService, Executors, FutureTask}

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util._

trait Student {
  var students: Map[String, Int] = Map("张三" -> 95, "李四" -> 98)

  def addstud(name: String, result: Int):Unit = () => students += (name -> result)
}

class School

object TestFuture extends scala.App {
  val sc = new School with Student
  println("---初始化学生--- ：" + sc.students)

  //创建Future，捕获程序执行情况
  val task = Future {
    Thread.sleep(5000)
    "Hello World"
  }

  //future上的回调方法，onComplete，onSuccess，onFailure
  task.onSuccess { case msg => println("succ = " + msg) }
  task.onFailure { case t => println("Fail,An error has occured = " + t.getMessage) }
  task.onComplete {
    case Success(value) => println(s"onComplete info = $value")
    case Failure(e) => e.printStackTrace
  }

  //线程池多次新增学生
  val threadPool: ExecutorService = Executors.newFixedThreadPool(3)

  try {
    for (i <- 1 to 3) {
      val future = new FutureTask[String](new Callable[String] {
        override def call(): String = {
          Thread.sleep(2000)
          sc.addstud("王五_" + i, 90 + i)
          return "future" + i
        }
      })
      threadPool.execute(future)
      println("future get : " + future.get())
      println("-------------新增学生王五----------- ：" + sc.students)
    }
  } finally {
    threadPool.shutdown()
  }
}
