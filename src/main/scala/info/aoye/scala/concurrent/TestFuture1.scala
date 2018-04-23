package info.aoye.scala.concurrent

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

/** 当程序中的某个过程执行时间较长,同时它与程序中的其他环节没有很强的关联性,那么这个过程便可以提取出来作为一个线程单独运行,
  * Scala中的Future便是用来解决此类问题,可以将用于并发执行的操作添加到Future中,然后在未来的某个时间点再获取其执行结果.
  */
object TestFuture1 extends scala.App {
  val s = "hello"
  //创建Future对象,对象中保存单个Future
  val function0: Future[String] = Future {
    Thread.sleep(2000)
    s + " future!"
  }
  //通过Future对象的foreach方法执行内容.
  function0.foreach(msg => println(msg))


  def helloWorld(str: String): Int = {
    Thread.sleep(1000)
    println(str)
    1
  }

  val function2: Future[Seq[Int]] = Future sequence Seq(
    Future(helloWorld("Hello?")),
    Future(helloWorld("Oh!!"))
  )

  //Future回调函数，当Future执行完成，会自动调用这个函数，输出函数结果
  function2 onComplete {
    case Success(Seq(x)) => println(x)
    case Success(Seq(x)) => println(x)
  }


  Thread.sleep(10000) //为了看到效果,主线程等待10秒.
}
