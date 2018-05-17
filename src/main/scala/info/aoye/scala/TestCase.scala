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
      case data1 if data == "Flink" => println("Cool " + data1) //匹配的时候将值赋值到一个变量,赋值data1=data,在后面可以使用这个变量
      case _ => println("Others") //下划线代表其他情况,java每行要写break,这里不用
      case _ if data == "Flink" => println("Cool") //可以写if进行判断,感觉没有什么用途?
    }
  }

  bigData("Flink")

  /**
    * 匹配值
    *
    * @param regcap 接收一个值
    */
  def parseRegCap(regcap: Double) {
    regcap match {
      case _regcap if _regcap < 100 => "1"
      case _regcap if _regcap >= 100 || _regcap < 500 => "2"
      case _regcap if _regcap >= 500 || _regcap < 1000 => "3"
      case _regcap if _regcap >= 1000 || _regcap < 2000 => "4"
      case _regcap if _regcap >= 2000 || _regcap < 5000 => "5"
      case _regcap if _regcap >= 5000 || _regcap < 10000 => "6"
      case _ => "7"
    }
  }

  println(parseRegCap(12345))

}
