package info.aoye.scala

/**
  * 隐式转换学习
  */
class TestImplicit {

  // 我们在定义方法时，可以把最后一个参数列表标记为implicit，表示该组参数是隐式参数。
  // 一个方法只会有一个隐式参数列表，置于方法的最后一个参数列表。
  // 如果方法有多个隐式参数，只需一个implicit修饰即可。
  // 在调用包含隐式参数的方法时，在调用的地方上下文必须有合适的隐式值，否则编译器报错。
  def calcTax(amount: Float)(implicit rate: Float): Float = {
    amount * rate
  }

  // 标记为隐式参数的我们也可以手动为该参数添加默认值。
  //  def foo(n:Int)(implicit t1:String,t2:Double=3.14)

  // 隐式的转换类型
  // 当编译器看到类型Double而却需要类型Int，它就在当前作用域查找是否定义了从类型Double到类型Int的隐式定义
  implicit def doubleToInt(d:Double) = d.toInt
  val i:Int = 3.5

}

