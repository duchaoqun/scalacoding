package info.aoye.scala

/**
  * scala 中使用while
  */
object TestWhile extends scala.App {
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
