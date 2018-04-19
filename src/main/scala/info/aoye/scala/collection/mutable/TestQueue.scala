package info.aoye.scala.collection.mutable

import collection.mutable.Queue
/**
  * scala 队列,该包里面是可以变化的队列.
  */
object TestQueue extends scala.App {
  // 定义一个可以变化的队列，队列里面可以包含任意对象
  // 注意：这里需要使用泛型
  // 注意：这里需要使用new关键字
  var queue1 = new Queue[List[String]]() //包含List字符串列表
  var queue2 = new Queue[(String, String)] //包含String->String类型二元组


  //向队列中插入内容
  //注意：这里需要注意 上面定义的Queue的类型 是 List[String] 下面添加内容的时候 使用List("str")
  queue1 += List("wo", "shi")       //注意:这个List作为一个元素插入到队列中
  queue1.enqueue(List("one","two")) //
  queue1 += List("sdf")
  queue1.enqueue(List("Hello"))

  queue2 += "key" -> "value"
  queue2 += "1" -> "23456"

  queue1.size         //查看队列中已经包含的内容数量
  queue1.dequeue()    //从队列里面取出一个内容,返回第一个元素,与不可变的queue不同.
  queue1.isEmpty      //查看队列是否为空。

  println(queue1)
  //TODO：可变队列和不可变队列的优缺点？
}
