package info.aoye.scala

/**
  * Scala 没有与 for（初始化变量,检查变量是否满足某条件,更新变量）循环直接对应的结构.
  * 1. for具体能取到什么内容,则取决后面表达式的类型(String就是每个字符,集合类型就是每个对象).
  * 2. 在Scala里面,对循环的使用并没有其他语言那么频繁.
  * 3. 想要跳出for循环,可以使用if条件守卫,也可以使用return关键字.
  */
object TestFor extends scala.App {
  // <- 是提取符号,获取对象里面的数值.
  val strArray = Array("one", "two", "three")
  for (i <- strArray.indices) { //todo indices 返回一个Range,里面是所引值?
    println(strArray(i))
  }
  // Scala 中的for循环结构
  for (i <- 1 to 10) {
    println(i)
  }

  // 最简单的遍历字符串
  val s = "duchaoqun"
  var sum = 0
  for (i <- 0 to s.length - 1) {
    sum += s(i)
  }

  // 高级的for， 使用<- 来定义一个生成器，实际上是两个循环过程
  for (i <- 1 to 3; j <- 1 to 3) {
    println(10 * i + j)
  }

  // 带守卫的for，if前面不需要分号
  for (i <- 1 to 3; j <- 1 to 3 if i != j) {
    println(10 * i + j)
  }

  // 带守卫的for，引入在循环中可以使用的from变量。
  for (i <- 1 to 3; from = 4 - i; j <- from to 3) {

  }

  // for推倒式   for comprehension!
  //TODO： for 推倒式 这里需要详细学习一下。
  val a = for (i <- 1 to 10) yield i % 3
  println(a.getClass)
  println(a)

  // 案例:for中添加if条件守卫,用于限制for循环(优化for循环,或者用于跳出for循环)
  var flag1 = true
  var sum1 = 0
  for (i <- 0 to 10 if flag1) {
    sum1 = sum1 + i
    if (i == 5) flag1 = false
  }

  // 案例:使用return跳出循环.
  def sum2(): Unit ={
    var sum2 = 0
    for (i <- 0 to 10) {
      sum1 = sum1 + i
      if (i == 5) return // return 是方法级别的,这里需要注意.
    }
  }
}
