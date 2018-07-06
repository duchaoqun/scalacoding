package info.aoye.basic.function

/**
  * 函数式编程进阶
  */
object TestFunctionB {
  def hiBigData(name: String) {
    println("Hi, " + name)
  }

  def main(args: Array[String]): Unit = {
    /**
      * 案例A 将函数赋值给一个变量? 在函数名称后面添加一个下划线,最后在代码中直接使用.
      * 函数和变量一样,作为scala的一等公民. 函数可以直接赋值给变量.
      */
    val hiData = hiBigData _
    hiData("Spark")

    /**
      * 案例B 匿名函数
      * 函数更常用的是匿名函数,定义的时候只需要说明输入参数的类型和函数体即可,不需要名称,
      * 但是如果你要使用的话,一般会把这个匿名函数赋值给一个常量val. 案例B
      */
    val f = (name: String) => println("Hi, " + name)
    f("Kafka")

    /**
      * 案例C 函数参数
      * 函数可以直接作为参数传递给函数, 这极大的简化了编程的语法, 为什么这么说呢? 原因很简单
      * 1. 以前Java的方式是new一个接口实例,并在接口实例的回调方法callback来实现业务逻辑, 现在直接把回调方法callback传递
      * 给我们的函数, 且在函数体中直接使用, 这毫无疑问的简化了代码的编写, 提升了开发效率.
      * 2. 这种方式非常方便编写复杂的业务逻辑和控制逻辑, 对于机器学习,深度学习,图计算等而言,至关重要.
      *
      * 说明: 将函数作为函数的参数传递的编程方式 称为高阶函数编程,Spark中60%都是使用这种方式编程.
      *
      * @param func 传递进来的函数
      * @param name 函数的参数
      */
    def getName(func: String => Unit, name: String): Boolean = {
      func(name)
      true
    }

    Array(1 to 10: _*).map(item => 2 * item).foreach(x => println(x))

    /**
      * 案例D 返回值也可以是函数, currying
      * 1. 当函数的返回类型是函数的时候, 这个时候就表明,scala的函数实现了闭包!
      * scala闭包的内幕是: scala的函数背后是类和对象, 所以scala的参数都作为了对象的成员, 所有后续可以继续访问, 这就是scala实现闭包原理的内幕.
      * 2. Currying, 复杂的函数式编程中经常使用, 可以维护变量在内存中的状态, 且实现返回函数的链式功能, 可以实现非常复杂的算法和逻辑.
      */
    def funcResultA = (name: String) => println("Hi, " + name)

    funcResultA("Spark")

    def funcResultB(message: String) = (name: String) => println(message + " Hi, " + name)

    funcResultB("BigData")("Spark") // 写法1 currying 柯里化函数写法, 必须掌握的写法, 实现复杂函数必备.

    val result = funcResultB("BigDate") // 写法2
    result("Spark")
  }
}
