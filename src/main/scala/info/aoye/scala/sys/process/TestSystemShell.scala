package info.aoye.scala.sys.process

import scala.sys.process._

object TestSystemShell extends scala.App {
  //执行外部命令,返回程序的执行过程
  val int1 = "/home/aoye/Documents/bash/test.sh".!!
  println(int1)

  //command argument error!
  //这里后面的时间参数传入到命令里面会被解析成两部分!!!   "2018-04-16  和 12:12:12" 中间被空格截断了.
  val int2 = """/home/aoye/Documents/bash/test.sh -- "2018-04-16 12:12:12" """.!!
  val int3 = """/home/aoye/Documents/bash/test.sh -- "2018-04-16 12:12:12" """.!
  println(int2)
  //解决办法:使用Seq来操作.
  val int4 = Seq("/home/aoye/Documents/bash/test.sh","--","2018-04-16 12:12:12").!!
  print(int4)

  val seq1:Seq[String]= Seq("/home/aoye/Documents/bash/test.sh","--","2018-04-16 12:12:12")

  println(seq1!)
}
