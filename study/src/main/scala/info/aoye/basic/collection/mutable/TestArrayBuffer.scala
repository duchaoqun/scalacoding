package info.aoye.basic.collection.mutable

import collection.mutable.ArrayBuffer

/**
  * scala 集合 : 可变的数据对象
  * 1. 所有数组能用的方法,数组缓冲区都能用.
  */
object TestArrayBuffer extends scala.App {
  //创建数组对象,注意泛型 和小括号
  val arraybuf1 = new ArrayBuffer[Int]()

  //对象添加值
  arraybuf1 += 1
  arraybuf1 += 2

  println(arraybuf1)
}
