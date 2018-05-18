package info.aoye.scala

/**
  * 1. scala中的基本数据类型
  * 2. scala拥有和java一样的数据类型,和java的数据类型的内存布局完全一致,精度也完全一致.
  * 3. 在类中,字段和方法笼统的被称为成员member,不管是val还是var
  * 4. 字段的另外一个说法是实例变量instance variable
  */
object TestDataType extends App {

  //构造单个基本对象
  var value1: Int = 123  //构造一个Int类型 变量 过程编程使用var,是可变的结构
  val value2: Int = 123  //构造一个Int类型 常量 函数式编程使用val，是一个不可变化的结构

  //构造多个基本对象
  val int1, int2: Int = 100
  val greeting, message: String = null

  //基本数值类型
  //1. 数字默认Int类型,后面加L或者l表示Long类型.
  //2. 浮点默认Double类型,后面加F或者f表示Float类型.
  val valueByte: Byte = -128      //8 bit  有符号数字,范围在-128    <->  127 之间
  val valueShort: Short = 32767   //16 bit 有符号数字,范围在-32768  <->  32767 之间
  val valueInt: Int = 1234567890  //32 bit 有符号数字,范围在-2147483648  <->  2147483647 之间
  val valueLong: Long = 99999999999999L  //64 bit 有符号数字,范围-9223372036854775808 <-> 9223372036854775807 之间
  val valueFloat: Float = 9999999999999999999999.99999999999F      //32 bit IEEE 754 单精度浮点数
  val valueDouble: Double = 99999999999999999999999999999999999D   //64 bit IEEE 754 双精度浮点数

  //基本字符类型
  //1. 字符是半角单引号括住的字符
  val valueChar: Char = 'a'            //16 bit Unicode字符.范围在 U+0000 <-> U+FFFF 之间.
  val valueStr1:String = "Hello!"      //字符串
  val valueStr2:String = """Hello!"""  //可以多行的字符串

  //特殊基本类型
  val boolean1: Boolean = true        //布尔类型
  val valueOther1:Unit = Unit         //表示无值，和其他语言中void等同
  val valueOther2:Unit = ()           //表示无值，和其他语言中void等同

  val valueOther3:Any = ""            //所有值类型的超类
  val valueOther4:AnyRef = ""         //所有引用类型的超类


  //基本类型转换
  val IntToString: String = 123.toString
  val StringToInt: Int = "99".toInt       // TODO: 这里IDEA的下划线代表神码意思？

  //算数和操作符重载
  val int3: Int = 2 * 3 + 4
  //在Scala中可以为方法使用各种符号来定义，操作符都是方法,下面两个方式是一样的
  int1 + int2
  int1.+(int2)
  //Scala中没有++和--操作符来提供递增递减运算，注意这里使用var来定义，这个需要是一个变量
  var int4: Int = 4
  int4 += 1


  //基本类型的伴生对象(Object)?
  println(Long.MaxValue)
  println(Long.MinValue)

  println(0 to 10)  //这里的to实际上是仅带一个int参数的方法，代码 0 to 2 被转换成方法{0}.to{2}。这个方法只有在明确指定方法调用的接受者时才有效。

  //todo 这里的for方法说明了scala的另外一个基本原则：方法若只有一个参数  i，调用的时候就可以省略点和括号。

  //从技术层面上来说，Scala没有操作符重载，它根本没有传统意义上的操作符，取而代之的是诸如 + - * / 这样的字符，可以用来做方法名。
  //如在交互解释器中，1 + 2 实际上是在Int对象1 上调用名为+的方法，把Int对象 2作为参数传递给它 (1).+(2)。

}
