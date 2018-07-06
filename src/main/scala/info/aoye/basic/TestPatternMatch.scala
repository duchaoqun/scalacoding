package info.aoye.basic


class DataFramework

case class RestFramework(name: String, popular: Boolean) extends DataFramework

case class PlayFramework(name: String, popular: Boolean) extends DataFramework

/**
  * scala 模式匹配
  * 一个模式匹配包含了一系列备选项,每个都开始于关键字case.每个备选项都包含了一个模式及一到多个表达式.箭头符号 => 隔开了模式和表达式.
  * scala中的case非常强大,既可以匹配值,匹配类型,匹配集合,匹配class,匹配object.
  */
object TestPatternMatch extends scala.App {
  /**
    * 案例A 匹配值
    * 1. 下划线代表其他情况,java每行要写break,scala这里不用
    * 2. 匹配字符串, 如果找到左面的字符串就执行右面的函数.
    * 3. case后面可以使用守卫来做判断
    *
    * @param name 接收一个值
    */
  def bigData(name: String, age: Int) {
    name match {
      case "Spark" => println("Wow! Spark!!")
      case "Hadoop" => println("Wow! Hadoop!!")
      case _name if age > 5 => println("Wow! many years!!" + _name + " : " + age) //接受值,赋给变量,然后再右边可以使用.
      case _ if name == "Scala" => println("Wow! Scala!!")
      case _ if name == "MR" => println("Oh! No! MR!!")
      case _ => println("What?? I don't understand.") // 其他情况的处理.
    }
  }

  bigData("Something", 6)

  /**
    * 案例B 匹配类型
    * 1. 匹配多种类型
    */
  def matchType(msg: Any): Unit = {
    msg match {
      case i: Int => println("Integer!!" + i)
      case s: String => println("String!!" + s)
      case d: Double => println("Double!!" + d)
      case _ => println("Unknown Type")
    }
  }

  /**
    * 案例C: 匹配一个集合类型对象
    *
    * @param array 数组内容
    */
  def matchArray(array: Array[String]): Unit = {
    array match {
      case Array("Scala") => println("这个Array对象中有一个内容,值是 Scala")
      case Array("Spark", _*) => println("这个数组里面的第一个元素是 Spark字符串,后面还有其他内容...")
      case Array(var1, var2, var3) => println(var1 + " " + var2 + " " + var3) //匹配长度为3的数组,将数组中的值绑定到变量里面
      case _ => println("Unknown")
    }
  }

  matchArray(Array("Scala")) //匹配到第一个case 并执行后面的语句
  matchArray(Array("Spark")) //匹配到第二个case ,当满足当前条件的时候,就永远不会向下面继续匹配了.需要注意
  matchArray(Array("Java", "Spark2")) //匹配到默认case _
  matchArray(Array("Java", "Spark2", "Spark3")) //匹配到绑定case,处理绑定的信息.
  matchArray(Array("Java", "Spark2", "Spark3", "Spark4")) //匹配到默认case _

  /**
    * 案例D: 批评case class
    */
  def matchFramework(data: DataFramework): Unit = {
    data match {
      case RestFramework(name, popular) => println("RestFramework: " + "name: " + name + " popular:" + popular)
      case PlayFramework(name, popular) => println("PlayFramework: " + "name: " + name + " popular:" + popular)
      case _ => println("Unknown Class")
    }
  }

  matchFramework(RestFramework("Boot v1",true))
  matchFramework(RestFramework("Boot v2",false))
  matchFramework(PlayFramework("2.6.x",true))

  /**
    * 匹配值
    *
    * @param double 接收一个值
    */
  def matchDouble(double: Double): String = {
    double match {
      case double1 if double1 < 100 => "1"
      case double1 if double1 >= 100 || double1 < 500 => "2"
      case double1 if double1 >= 500 || double1 < 1000 => "3"
      case double1 if double1 >= 1000 || double1 < 2000 => "4"
      case double1 if double1 >= 2000 || double1 < 5000 => "5"
      case double1 if double1 >= 5000 || double1 < 10000 => "6"
      case _ => "7"
    }
  }

  import java.io.FileNotFoundException

  /**
    * 匹配一个类型,这个是错误类型
    *
    * @param e 错误类型
    */
  def exception(e: Exception): Unit = {
    e match {
      case x: FileNotFoundException => println("File not Found. " + x)
      case _: Exception => println(e)
    }
  }

  exception(new FileNotFoundException("Oh,No!")) //File not Found. java.io.FileNotFoundException: Oh,No!

}
