package info.aoye.test

class TestFunction {
  //定义一个函数：
  //注意：必须给出所有参数的类型，如果函数体不是递归的，那么我们不需要定义返回值类型，编译器会自动推断
  def abs(x: Double) = if (x >= 0) x else -x

  //如果一行写不下可以使用花括号和多行的方式
  def fac(n: Int) = {
    var r = 1
    for (i <- 1 to n) r = r * i
    //最后一个表达式就是返回值，不需要return
    r
  }

  //默认参数：
  //在调用的时候不显式的提供参数，就使用默认的参数
  //在调用的时候根据名字提供参数println(a.decorate(str="duchaoqun",left = "(((",right = ")))"))
  def decorate(str: String, left: String = "[", right: String = "]") = {
    left + str + right
  }

  //变长的参数：
  //函数得到的是一个Seq类型的参数，包含多个Int值。
  //注意: 函数接收一个整体，在调用的时候 1 to 5: _*
  def sum(args: Int*) = {
    var result = 0
    for (x <- args) result += x
    result
  }
}

object TestFunction extends scala.App {
  val a = new TestFunction
  println(a.abs(-123.345))
  println(a.fac(5))
  println(a.decorate("duchaoqun"))
  println(a.decorate(str = "duchaoqun", left = "(((", right = ")))"))
  println(a.sum(1 to 100: _*))

  val list1 = List(1, 2, 3, 4, 5, 6)
  list1.foreach(x => println(x))
}
