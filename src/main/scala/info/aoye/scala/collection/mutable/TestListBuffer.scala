package info.aoye.scala.collection.mutable

import collection.mutable.ListBuffer

/**
  * 列表缓冲区
  */
object TestListBuffer extends scala.App {
  //创建缓冲区对象,注意泛型
  val listbuf1 = new ListBuffer[Int]

  //缓冲区对象结尾添加值,返回原来的Buffer
  listbuf1 += 1
  listbuf1 += 2
  listbuf1 += 2

  //缓冲区对象开头添加值,返回新的Buffer
  val listbuf2 = 3 +: listbuf1

  println(listbuf1)
  println(listbuf2)

  //转换尾List[Int]对象
  listbuf1.toList
  listbuf2.toList
}
