package info.aoye.scala

case class Host(address: String, port: Int)

case class ABCException(msg: String) extends Exception

/**
  * 说明：设计一个类只是用来作为数据载体时，Case Class是一个很好的选择，实际上，这正是DTO（或者也有叫作VO）做的事情
  * 所以说Case Class的一个典型应用场景就是DTO
  *
  *   - 伴生对象自动包含apply方法，代替new方式声明对象
  *   - 伴生对象自动版本unapply方法，
  */
object TestCaseClass extends App {

  //构建一个对象:实际是调用Host类的伴生对象的apply方法.
  println(Host("127.0.0.1", 65535))
  println(Host.apply(address = "8.8.8.8", port = 2232))
  val p1 = Host("123.123.123.123", 8848)
  val p2 = Host.apply("8.8.8.8", 8080)

  //伴生对象自动生成的方法,
  println(Host.hashCode())
  println(Host.toString())

  val p3 = p1.isInstanceOf[Host]  //判断对象类型?
  val p4 = Host.equals()  //? 有待深入学习 ?

  println(p3)

  //获取内容?返回一个Some对象
  val someThing1 = Host.unapply(p1)
  println(someThing1) //class scala.Some

  try {
    throw ABCException("Error")
  } catch {
    case ex: Exception => println(ex.toString)
  } finally {
    println("Over")
  }
  //
}
