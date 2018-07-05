package info.aoye.scala.function

/**
  * scala根里面有22个function特质,
  * 1. 函数可以简单的包裹一条或者几条语句,该代码接受若干参数,经过代码处理后返回结果.型如数学中的 F(x)=x + 1
  * 2. 在scala中,函数是一等公民,可以像变量一样被传递,被赋值,同时函数可以赋值给变量.变量也可以赋值给函数.之所以会这样,原因是因为函数背后是一个对象,也就是说这个函数其实是一个变量(是Scala帮助我们自动生成的)
  * 可以天然的被序列化和反序列化,
  * 意义: 可以天然的序列化和反序列化的直接好处就是函数可以在分布式系统上传递.
  * 意义: 因为函数背后其实是类和对象,所以可以和普通的的变量完全一样的运用在普通变量可以运用的地方,包括作为参数传递,作为返回值被变量赋值,和赋值给变量.
  *
  * 补充:整个IT编程技术的发展史,其实就是一部封装史
  * 1. Function时代:C语言中提供了函数的概念,把若干条语句进行封装和复用.
  * 2. Class时代:C(java)等语言提供类的对象,把数据和处理数据业务的逻辑封装起来.
  * 3. 框架时代:最大的封装就是使用框架!把数据,代码和驱动封装起来.
  *
  * 关于函数入门的几个特点:
  * 1. def关键字来定义函数
  * 2. 函数会自动进行类型推断,来推断函数的返回值类型.注意：必须给出所有参数的类型,如果函数体不是递归的,那么我们不需要定义返回值类型,编译器会自动推断
  * 3. 如果函数名称和函数体之间没有等号,那么该函数的返回值类型会推断失败(不是函数体最后一条语句的结果类型),这个函数的结果类型是Unit. 见如下A-B案例.
  * 4. 如果在函数体中,无法推倒出具体的结果类型,则必须声明结果类型.例如案例C
  * 5. 函数的参数可以有默认值,这样在调用函数的时候,如果不想改变默认值的话,这样就不传递该参数,直接使用默认值,这在变成中意义重大,这在Spark等变成中非常有用,因为框架一般有自己的默认配置和实现
  * ,这时就非常好的使用默认值了.
  * 6. 我们可以基于函数的参数的名称,来调整函数的传递参数的顺序.重点在于为什么可以这么做呢? 原因在于函数背后就是类! 其参数就是类的成员,所以无所谓顺序. 见如下案例E
  * 7. 可变参数中的数据其实被收集成为Array数组.例如main的args 就是Array[String]的方式来实现的.
  *
  * 补充: 不依赖于类的def就是函数,依赖于类的叫做方法,没有返回值的叫做过程.
  */
object TestFunctionA extends scala.App {

  //案例A-B:如果函数名称和函数体之间没有等号,那么该函数的返回值类型会推断失败(不是函数体最后一条语句的结果类型),这个函数的结果类型是Unit.
  def functionA(name: String, age: Int) = {
    println("Nmae is " + name)
    println("Age is  " + age)
    age //最后一个表达式就是返回值，不需要return
  }

  def functionB(name: String, age: Int) {
    println("Nmae is " + name)
    println("Age is  " + age)
    age
  }

  //案例C:斐波那契数列,简单的递归调用.注意这里需要定义结果类型.
  def fibonacci(n: Long): Long = {
    if (n < 1) 1
    else fibonacci(n - 2) + fibonacci(n - 1)
  }

  val result = fibonacci(30)
  //println("Fibonacci is :" + result)

  //案例D:默认参数：
  //在调用的时候不显式的提供参数，就使用默认的参数
  //在调用的时候根据名字提供参数println(a.decorate(str="duchaoqun",left = "(((",right = ")))"))
  def decorate(str: String, left: String = "[", right: String = "]"): String = {
    left + str + right
  }

  //案例E: 可变参数
  //变长的参数：函数得到的是一个Seq类型的参数?,包含多个Int值. todo: 这里是Seq 还是Array需要深入学习.
  def sum(args: Int*): Int = {
    println(args.getClass)
    var result = 0
    for (x <- args) result += x
    result
  }
  //注意: 如果函数接收一个整体,则在调用的时候需要加 : _* 将输入作为一个整体处理,例如(1 to 5: _*)
  println(sum(1 to 1000: _*))


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
