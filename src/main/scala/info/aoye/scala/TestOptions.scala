package info.aoye.scala

/**
  * 避免null使用大多数语言都有一个特殊的关键字或者对象来表示一个对象引用的是"无",在Java,它是null.
  * 在Java里,null是一个关键字,不是一个对象,所以对它调用任何方法都是非法的.但是这对语言设计者来说是一件令人疑惑的选择.
  * 为什么要在程序员希望返回一个对象的时候返回一个关键字呢?
  *
  * Scala的Option类型:
  * 为了让所有东西都是对象的目标更加一致,也为了遵循函数式编程的习惯,Scala鼓励你在变量和函数返回值可能不会引用任何值的时候使用Option类型.
  * 在没有值的时候,使用None,这是Option的一个子类.
  * 如果有值可以引用,就使用Some来包含这个值,Some也是Option的子类.
  * None被声明为一个对象,而不是一个类,因为我们只需要它的一个实例.
  * 这样,它多少有点像null关键字,但它却是一个实实在在的,有方法的对象.
  *
  * 1. Option类型的值通常作为Scala集合类型(List,Map等)操作的返回类型.
  */
object TestOptions extends App {
  //定义一个Map类型对象
  val map1: Map[String, String] = Map("abc" -> "bbc")

  //Map对象的get方法返回一个Option类型对象.
  val opt1: Option[String] = map1.get("abc") //Some(bbc)
  val opt2: Option[String] = map1.get("bcd") //None

  //取出Option对象中的内容:
  opt1.getOrElse(0) //bbc  如果没有就返回0
  opt2.getOrElse(0) //0    如果没有就返回0


  //详解Option[T]
  //1. 在Scala里Option[T]实际上是一个容器,就像数组或是List一样,你可以把他看成是一个可能有零到一个元素的List.
  //2. 当你的Option里面有东西的时候,这个List的长度是1(也就是Some),而当你的Option里没有东西的时候,它的长度是0(也就是None).
  opt1.size //返回1
  opt2.size //返回0

  //如下也可以使用case match方式进行操作
  def show(option: Option[String]) = option match {
    case Some(s) => s //这里是一个很有意思的写法,如果有值,就返回这个值
    case None => "?" //如果没有值,结果就是None,返回?字符.
  }

  show(map1.get("abc")) //返回bbc,
  show(map1.get("bbb")) //返回 ?

  // idEmpty 判断是否有值
  val opt3: Option[String] = Some("Hello")
  val opt4: Option[String] = None
  opt3.isEmpty // 返回 "false"
  opt4.isEmpty // 返回 "true"


  /* 技巧:当结果是None的时候需要进行判断,如下技巧可以减少对None的判断 */
  // for 与 option
  //1. for 遍历 option对象里面的内容,有值实际上就是获取Some(x)的内容
  //2. 无值就是没有返回内容,达到不用检查Option是否为None这件事.
  val map2 = Map("key1" -> "value1")

  val value1 = map2.get("key1")
  val value2 = map2.get("key2")

  def printContentLength(x:Option[String])={
    for ( c <- x){
      println(c.length)
    }
  }
  printContentLength(value1)  //返回6
  printContentLength(value2)  //无返回

  // option Map 操作,将Option容器中的内容进行一部操作,然后返回另外一个新容器.

  val map3 = Map("key1"->"values1")
  val opt5 = Option("HelloWorld!")
  val opt6 = Option("")
  opt5.map(_.length).map("Length:"+_).foreach(println(_))
  opt6.map(_.length).map("Length:"+_).foreach(println(_))
}
