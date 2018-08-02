package info.aoye.basic.TestPartialFunction

/**
  * 偏函数(Partial Function), 是一个数学概念它不是"函数"的一种, 它跟函数是平行的概念.
  * Scala中的Partial Function是一个Trait, 它的类型为PartialFunction[A,B], 其中接收一个类型为A的参数, 返回一个类型为B的结果.
  */
object PartialFunction extends scala.App {
  //todo 偏函数内部有一些方法，比如isDefinedAt、OrElse、 andThen、applyOrElse等等.
  val pf: PartialFunction[Int, String] = {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
  }
  val pfFour: PartialFunction[Int, String] = {
    case 4 => "Four"
  }
  val pfFive: PartialFunction[Int, String] = {
    case 5 => "Five"
  }

  val pfNote:PartialFunction[String,String] = {
    case x if x =="Five" => "This is Five!!"
  }

  println(pf(1)) // 使用偏函数

  /**
    * 偏函数特有的方法
    * 1. isDefinedAt : 这个函数的作用是判断传入来的参数是否在这个偏函数所处理的范围内
    * 2. orElse : 将多个偏函数组合起来使用, 效果类似case语句
    * 3. andThen: 相当于方法的连续调用, 比如g(f(x))
    * 4. applyOrElse: 它接收2个参数, 第一个是调用的参数, 第二个是个回调函数. 如果第一个调用的参数匹配, 返回匹配的值, 否则调用回调函数.
    */

  //1. isDefinedAt : 这个函数的作用是判断传入来的参数是否在这个偏函数所处理的范围内
  println(pf.isDefinedAt(5)) // 如果输入1 该偏函数可以处理就会返回true,其他不能处理的时候就返回false

  //2. orElse : 将多个偏函数组合起来使用, 效果类似case语句
  val newPf = pf orElse pfFour orElse pfFive
  println(newPf(5))

  //3. andThen: 相当于方法的连续调用, 比如g(f(x))
  val newPf1 = pfFive andThen pfNote //注意:pfFive的结果返回类型必须和pfNote的参数传入类型必须一致,否则会报错.
  println(newPf1(5))

  //4. applyOrElse: 它接收2个参数, 第一个是调用的参数, 第二个是个回调函数. 如果第一个调用的参数匹配, 返回匹配的值, 否则调用回调函数.
  println(pfFive.applyOrElse(5,"Other"))
  println(pfFive.applyOrElse(4,{num:Int => s"Other + $num"})) //todo 这里是个很意思的写法.

}
