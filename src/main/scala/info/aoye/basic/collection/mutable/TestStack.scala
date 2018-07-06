package info.aoye.basic.collection.mutable

import scala.collection.mutable
import scala.collection.mutable.Stack

/**
  * scala 中 栈也有可变和不可变两种,这里使用可变的栈
  */
object TestStack extends App {
  //创建对象,这个是包对象? todo:有待学习
  val stack1 = new mutable.Stack[Int]()

  //压栈操作
  stack1.push(1)
  stack1.push(2)

  //弹栈操作
  println(stack1.top)   //获取不进行弹栈操作
  println(stack1.pop()) //获取并弹栈
  println(stack1.pop())
}
