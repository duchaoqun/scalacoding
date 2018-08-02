package info.aoye.basic.collection

/**
  * 1. 在scala的集合体系中,Iterable是共同的Trait, Iterable要求继承者实现一些共同的方法, 例如对元素的遍历(迭代)等.
  * 2. Array是一个非常基础的数据结构, 不从属于scala集合的体系.
  * 3. scala的集合体系中, 集合分为可变集合和不可变集合之分.
  *    不可变集合在scala.collection.immutable包中
  *    可变几何在scala.collection.mutable包中
  * 4. List是元素的列表集合, 是不可变的.
  *    - List中head是指第一个元素,tail是指剩下的元素构成的集合.
  */
object FunctionalIterable extends scala.App {
  val range = 1 to 10

  val list = List(1,2,3,4,5)
  println(list.head)
  println(list.tail)

  val set = Set(1,2,3,4)
}
