package info.aoye.scala

object TestFor {
  def main(args: Array[String]): Unit = {
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

  }
}
