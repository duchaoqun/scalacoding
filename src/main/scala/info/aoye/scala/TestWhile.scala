package info.aoye.scala


/**
  * scala 中使用while
  * 1. 一般情况下,跳出循环一般使用flag来做.
  */
object TestWhile extends scala.App {

  // 案例: 有个逻辑有问题的跳出循环
  var flag = true
  while (flag) {
    for (item <- "Spark") {
      println(item)
      if (item == 'r') flag = false  // 这里会完成一次循环才能跳出,逻辑有些问题.
    }
  }

  // 案例: 使用breakable来跳出循环
  import scala.util.control.Breaks._
  breakable{
    while (flag) {
      for (item <- "Spark") {
        println(item)
        if (item == 'r') break
      }
    }
  }




  var int1 = 0
  while (int1 < args.length) {
    println(args {
      int1
    }) //注释内容，使用两个反斜杠或者放在/* */之间
    i += 1 //规范的代码使用两个空格缩进，注意i++ 和++i 不被scala支持。
  }

  var i = 0
  while (i < args.length) {
    if (i != 0)
      print(" ")
    print(args {
      i
    })
    i += 1
  }
}
