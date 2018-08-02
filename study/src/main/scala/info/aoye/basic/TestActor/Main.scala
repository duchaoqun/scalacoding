package info.aoye.basic.TestActor

/**
  * 使用akka Actor 最简单的例子
  *
  * 多线程在2.10以后的版本里面单独发布，需要添加如下引用才可以。
  * libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.8"
  *
  * //上面的内容也已经过时了, 建议使用如下包进行相关开发任务
  * // https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
  * libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.11"
  * Actor通过尽可能避免锁和共享状态, Actor使得我们能够更容易地设计出正确, 没有死锁或争用状况的程序.
  *
  */

import akka.actor.{Actor,ActorSystem,Props}

/**
  * 定义一个Actor,实现Receive方法
  * 1. 实现receive方法,如果收到test怎么处理,收到其他内容怎么处理.
  */
class HelloActor extends Actor{
  override def receive: Receive = {
    case "Hello" => println("您好!"+ Thread.currentThread().getName)
    case "Exit" => //todo 如何安全终止这个线程?
    case _ => println("您是?")
  }
}

object Main extends scala.App{

  // 声明一个ActorSystem,所有用户定义的Actor的宿主环境
  val system = ActorSystem("HelloSystem")  //线程名字HelloSystem-akka.actor.default-dispatcher-3

  // 创建一个Actor实例, 返回结果类型尾ActorRef, 这里用的是默认构造函数, 这可以理解成一个线程吗?  todo// 需要深入学习
  val helloActor = system.actorOf(Props[HelloActor],name = "ActorOne")

  // 给Actor发送消息.
  helloActor ! "Hello"
  helloActor ! "asdf"
  helloActor ! "Exit"

  //TODO 线程如何复用? 怎么做呢?



}
