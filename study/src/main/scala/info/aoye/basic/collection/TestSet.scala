package info.aoye.basic.collection

/**
  * Set是元素不可重复的集合,所有的元素都是唯一的
  * 1. Set里面元素是不可变的,也是无序的.
  * 2.
  */
object TestSet extends App {
  // 定义一个Set对象
  val set = Set(1, 2, 3, 4, 5)

  // 添加元素到Set: 失败,已经存在元素 1 ,因为1已经重复了, 这里不会有任何变化.
  val set1 = set + 1

  // hashSet 是不可变的,也是无序的
  val hashSet1 = scala.collection.mutable.HashSet(1,2,3,4,5)

  // linkedSet 可以保证元素顺序.
  val linkedHashSet1 = scala.collection.mutable.LinkedHashSet(1,2,3)
  linkedHashSet1 += 40
  linkedHashSet1 += 5

  // sortedSet 会自动把插入的元素进行排序.
  val sortedSet1 = scala.collection.mutable.SortedSet(1,2,3,5,4,50)
  println(sortedSet1)
}
