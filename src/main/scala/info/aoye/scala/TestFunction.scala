package info.aoye.scala

/**
  * scala根里面有22个function特质,
  */
class TestFunction {
  //定义一个函数：
  //注意：必须给出所有参数的类型，如果函数体不是递归的，那么我们不需要定义返回值类型，编译器会自动推断
  def abs(x: Double): Any = if (x >= 0) x else -x

  //如果一行写不下可以使用花括号和多行的方式
  def fac(n: Int): Int = {
    var r = 1
    for (i <- 1 to n) r = r * i
    //最后一个表达式就是返回值，不需要return
    r
  }

  //默认参数：
  //在调用的时候不显式的提供参数，就使用默认的参数
  //在调用的时候根据名字提供参数println(a.decorate(str="duchaoqun",left = "(((",right = ")))"))
  def decorate(str: String, left: String = "[", right: String = "]"): String = {
    left + str + right
  }

  /**
    *
    * @param args 变长的参数：函数得到的是一个Seq类型的参数,包含多个Int值.
    * @return
    * 注意: 如果函数接收一个整体,则在调用的时候需要加 : _* 将输入作为一个整体处理,例如(1 to 5: _*)
    */

  def sum(args: Int*): Int = {
    var result = 0
    for (x <- args) result += x
    result
  }
}

object TestFunction extends scala.App {
  val a = new TestFunction
  println(a.abs(-123.345))
  println(a.fac(5))
  println(a.decorate("Hello"))
  println(a.decorate(str = "Hello", left = "(((", right = ")))"))
  println(a.sum(1 to 100: _*))

  val list1 = List(1, 2, 3, 4, 5, 6)
  list1.foreach(x => println(x))

  def javaVersion1(): Unit = () => scala.sys.props("java.version") //如返回Unit则需要参数,仅使用方法的副作用处理输入对象
  def javaVersion2 = () => scala.sys.props("java.version") //不需要参数,定义的是方法?
  def test1(): Unit = {
    scala.sys.props("java.version")
  }

  //没有参数的函数.
  val javaVersion = () => scala.sys.props("java.version")
  //  val function0 = new Function0[String] {
  //    def apply(): String = scala.sys.props("java.version")
  //  }


  //一个参数的函数.
  val function1 = (x: Int) => x + 1

}
