package info.aoye.scala


/**
  * scala 模式匹配
  * 一个模式匹配包含了一系列备选项,每个都开始于关键字case.每个备选项都包含了一个模式及一到多个表达式.箭头符号 => 隔开了模式和表达式.
  * scala中的case非常强大,既可以匹配值,匹配类型,匹配集合,匹配class,匹配object.
  */
object TestCase extends scala.App {
  /**
    * 匹配值
    *
    * @param data 接收一个值
    */
  def bigData(data: String) {
    data match {
      case "Spark" => println("Wow!") //匹配字符串,如果找到左面的字符串就执行右面的函数.
      //case 后面接一个变量,会将当前要匹配的对象赋值给这个变量,然后使用守卫进行判断,如果不匹配就继续执行.
      case data1 if data1 == "Flink" => println("Cool " + data1)
      case _ => println("Others") //下划线代表其他情况,java每行要写break,这里不用
      case _ if data == "Flink" => println("Cool") //可以写if进行判断,感觉没有什么用途?
    }
  }

  bigData("Flink")

  /**
    * 匹配值
    *
    * @param double 接收一个值
    */
  def matchDouble (double: Double):String = {
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


  /**
    * 匹配一个Array类型对象
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


}
