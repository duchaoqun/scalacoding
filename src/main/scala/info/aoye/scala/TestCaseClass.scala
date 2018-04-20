package info.aoye.scala

case class host(address: String, port: Int)

case class ABCException(msg: String) extends Exception

/**
  * 说明：设计一个类只是用来作为数据载体时，Case Class是一个很好的选择，实际上，这正是DTO（或者也有叫作VO）做的事情
  * 所以说Case Class的一个典型应用场景就是DTO
  *
  *   - 伴生对象自动包含apply方法，代替new方式声明对象
  *   - 伴生对象自动版本unapply方法，
  */
object TestCaseClass extends App {

  // 声明一个对象
  println(host("127.0.0.1", 65535))
  println(host.apply(address = "8.8.8.8", port = 2232))
  val p1 = host("123.123.123.123", 8848)

  // 伴生对象自动生成的方法
  println(host.hashCode())
  println(host.toString())
  val p2 = host.equals(p1.getClass)

  // 返回一个Some对象
  val someThing1 = host.unapply(p1)
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