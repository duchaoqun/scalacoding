package info.aoye.test

/**
  * 使用字符串
  * 1. 字符串是不可变对象,在做相应的操作之后需要定义一个新对象来接收,如果需要使用可变内容,可以先了解StringBuilder
  * 2. RichString序列,它的类型是Seq[Char].因为Predef包含了从String到RichString的隐式转换,所以你可以把任何字符串当作Seq[Char]
  */
object TestString extends scala.App {

  //定义字符串
  val str0 = "duchaoqun" //可以不用指定类型
  val str1: String = "Hello" //指定类型
  val str2: String = "World"
  val str8 = "我是中国人啊啊啊！"

  str1.length //字符串长度
  str1.dropRight(1) //去掉结尾字符

  //连接字符串
  val reStr1 = str1.concat(str0)
  val reStr2 = str1.concat("ddd")
  val reStr3 = str0 + str2

  //TODO: 格式化字符串，需要学习

  //简单的重新处理
  val str3 = "pripid,entname"
  var str4 = ""
  str3.split(",").toList.map(x => str4 += x + ",")
  println(str3)
  println(str4.dropRight(1))

  //使用多行字符
  //stripMargin 方法去掉默认的行分割符 | ，然后使用字符串的replaceAll方法转换成一行
  val str5 =
  """I have
    |a
    |Dream!
  """.stripMargin.replaceAll("\n", " ")

  val str6 = "Just do it!" :: Nil // 将一个字符串类型，转换成一个列表类型
  str1.distinct // 获取字符串中不重复的字符

  // 提取第几个字符，如下两个方式都可以，可以吧()理解为apply的方法重载。
  str1.apply(4) // 申请第四个字符内容，() 操作符其实是重载了apply方法，下标是以0开始的
  str1(4) // 注意偶尔() 会跟隐式参数冲突，所以尽量使用apply方法

  str1.take(1) //  获取字符串最前面“1”个字符，可以获取多个字符，下标是以1开始的
  val str7 = str1.sorted

  //在字符串中插入变量
  val str9 = "12345"
  println(s"I am : $str9")

  val str10 = "\'123+456\'"
  println(str10)
  println(str10.replace("\'",""))

  val str11 = "eleven"
  println("\""+str11+"\"")

}
