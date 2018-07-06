package info.aoye.basic.util.control

import scala.util.control.Breaks

object TestBreaks extends scala.App {

  val loop = new Breaks
  // breakable 放在循环里面,实现continue的过程
  for (x <- 1 to 10) {
    loop.breakable(
      if (x % 2 == 0) {
        loop.break
      } else {
        println(x)
      }
    )
  }

  // breakable 放在循环外面,实现break的过程
  loop.breakable(
    for (x <- 1 to 10) {
      if (x > 5) loop.break() else println(x)
    }
  )
}
