package info.aoye.basic.TestImplicit

/**
  * Scala隐式转换
  * 使用场景1:将某一类型转换成预期类型,值类型,对象类型等?
  * 使用场景2:“隐式类”形式的隐式转换
  */
object TestImplicit extends scala.App {

  //我们在定义方法时,可以把最后一个参数列表标记为implicit,表示该组参数是隐式参数.
  //一个方法只会有一个隐式参数列表,置于方法的最后一个参数列表.
  //如果方法有多个隐式参数,只需一个implicit修饰即可.
  //在调用包含隐式参数的方法时,在调用的地方上下文必须有合适的隐式值,否则编译器报错.

  //案例1,定义一个方法,接收一个Float类型对象,隐式接收一个Float对象,返回Float对象.
  def calcTax(amount: Float)(implicit rate: Float): Float = {
    amount * rate
  }

  // 标记为隐式参数的我们也可以手动为该参数添加默认值。
  //  def foo(n:Int)(implicit t1:String,t2:Double=3.14)

  // 隐式的转换类型


  //示例1: 隐式转换类型.
  //1. 定义隐式方法,也可以从其他地方引入隐式方法,例如scalaApi,它居然做了不可描述的事情(+1)
  //2. 从Double类型转换到Int类型
  //3. 编译器会根据上下文寻找 输入输出参数,与隐式转换函数名称无关
  implicit def doubleToInt(d: Double): Int = d.toInt + 1
  val int1: Int = 3.5 //当编译器看到类型Double而却需要类型Int,它就在当前作用域查找是否定义了从类型Double到类型Int的隐式定义
  println(int1)


  //示例2: 方法的隐式参数


  //示例3: 隐式类
  import TestImplicitClass._  //导入隐式类里面所有的隐式内容
  println(1.add(2))  //在当前作用域中寻找 将Int（1） 作为变量的类同时具有add 的方法的类，如有，则执行

  //todo https://blog.csdn.net/a2011480169/article/details/52999745
}

