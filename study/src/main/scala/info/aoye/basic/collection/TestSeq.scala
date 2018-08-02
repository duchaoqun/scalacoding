package info.aoye.basic.collection

import collection.Seq

/**
  * 1. Seq是一个特质(trait~interface).
  * 2. 适合存有序重复数据,进行快速插入/删除元素等场景.
  * 3. 注意返回的是一个列表因为Seq是一个特质；而列表是序列的很好实现,Seq也是一个工厂单例对象,可以用来创建列表.
  */
object TestSeq extends scala.App {
  //创建列表
  val list1 = Seq(1, 1, 2, 2, 3, 3, "a", "b", "c", "hello")
  println(list1.getClass) //class scala.collection.immutable.$colon$colon
  println(list1) //List(1, 1, 2, 2, 3, 3, a, b, c, hello)

  println(list1 ++: ("d"))
}
