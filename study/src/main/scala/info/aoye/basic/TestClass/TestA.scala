package info.aoye.basic.TestClass

/**
  * 在Java中List<String>和List<Int>类型是不一样的, 但是jvm编译时会进行"泛型擦除".
  * 导致List<String>和List<Int>都是Class<List>为了得到正确的类型,需要通过反射.
  * Java中的泛型基本上都是在编译器这个层次来实现的.在生成的Java字节码中是不包含泛型中的类型信息的.
  * 使用泛型的时候加上的类型参数,会在编译器编译代码的时候去掉.这个过程就称为类型擦除.
  * 泛型擦除是为了兼容jdk1.5之前的jvm,在这之前是不支持泛型的.
  *
  */
object TestA extends scala.App {
  val listClass = classOf[List[_]]
  val mapIntString = classOf[Map[Int,String]]
}
