package info.aoye.basic

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

/**
  * //多线程在2.10以后的版本里面单独发布，需要添加如下引用才可以。
  * libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.8"
  *
  * //上面的内容也已经过时了，建议使用如下包进行相关开发任务
  * // https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
  * libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.11"
  *
  * Actor 通过尽可能避免锁和共享状态，Actor使得我们能够更容易地设计出正确，没有死锁或争用状况的程序。
  */
class HelloActor extends Actor { //定义一个Actor，实现Receive方法
  val log = Logging(context.system, this)

  /**
    * 实现receive方法，如果收到test怎么处理，收到其他内容怎么处理
    *
    * @return
    */
  override def receive: Receive = {
    case "test" => {
      Thread.sleep(10000)
      log.info("received test!")
    }
    case _ => log.info("received unknown message!")
  }
}

object TestActor extends App {
  //声明一个ActorSystem,所有用户定义的Actor的宿主环境
  val system = ActorSystem("HelloSystem")
  val actorSystem = ActorSystem("UniversityMessageSystem")

  //创建一个Actor实例，返回结果类型尾ActorRef，这里用的是默认构造函数，
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  //如下是发送三个消息给Actor，

  for (x <- 1 to 100) {
    if (x % 2 == 0) {
      helloActor ! "test"
    } else {
      helloActor ! "adsf"
    }
  }
}
//TODO:需要深入学习

