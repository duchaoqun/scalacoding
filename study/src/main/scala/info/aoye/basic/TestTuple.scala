package info.aoye.basic

/**
  * scala 基本集合类型 tuple
  * 1. 元组也是不可变的,但与列表不同的是元组可以包含不同类型的元素,注：该元组的类型由其保存的内容决定。
  * 2. 元组只能包含22个元素!?  scala根包中有tuple1 -> tuple22
  * 3. 元组的下标是从1开始的.
  * 4. 一个重要的作用就是用作函数的返回值,在Tuple中返回若干值.
  */
object TestTuple extends scala.App {

  // 定义元组
  val tup1 = (1,"dd")  //最常使用的二元组，类型是Tuple[Int,String]
  val tup2 = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22) //最多22个元素
  val tup3 = ('1',"abc",123,List(1,2,3))  //可以包含任意类型的对象

  // 最常用的二元组，可以省略括号，在与Map相关的操作的时候用
  val tup4 = ("key" -> "value")  // 不推荐使用,这里IDEA会给提示
  val tup5 = ("key1","value1")   // 模式1
  val tup6 = "key" -> "value"    // 模式2,最简洁的方式

  // 访问元组
  // 1、元组的下标是从1开始的。
  println(tup2._18)
  print(tup4.getClass)
  println(tup4)

  //TODO： Tuple结构与List结构的优缺点对比？
}
