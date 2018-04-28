package info.aoye.scala.TestImplicit

/**
  * 隐式类,隐式类需要放置在类里面,不能直接放在package里面.
  * 1. 在使用的时候直接 import TestImplicitClass.TestImplicitClass
  * 2. 隐式类的运作方式是：隐式类的主构造函数只能有一个参数(有两个以上并不会报错,但是这个隐式类永远不会被编译器作为隐式类在隐式转化中使用),且这个参数的类型就是将要被转换的目标类型.从语义上这很自然:这个隐式转换类将包裹目标类型,隐式类的所有方法都会自动"附加"到目标类型上.
  */
object TestImplicitClass {

  /**
    * 对类的加强? 拓展了目标的方法,实现类的增强和扩展.
    * 如下,如果那个类引入了次隐式类,当执行Int类型对象时,就多了一个方法!
    *
    * @param int1
    */
  implicit class ImpInt(int1: Int) {
    def add(int2: Int) = int1 + int2  //被引用的地方,可以使用 123.add 方法,这样就扩展了原有的内容
  }

  implicit class TmpString(str: String) {
    def str2int(str: String) = str.toInt
  }

}




