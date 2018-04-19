package info.aoye.scala.collection.immutable

object MainVector extends scala.App {
  //向量？
  val a = Vector(1, 2, 3, 4, 5)
  //map方法逻辑，将源容器中的内容经过函数操作，映射到一个新的容器里面，这个函数可以是自定义的任何函数
  println(a.map(x => x + 1))

  //reduce方法逻辑，实际象是尾递归函数？自己调用自己？不断的执行函数？
  //如下两种方式的效果是一样的
  //注意，reduce只能接受二元参数
  println(a.reduce((m, x) => m + x)) //取两个值，然后做加法运算，返回值后做递归（返回值+下一个元素）
  println(a.reduce(_ + _)) //默认是执行reduceLeft方法
  println(a.reduceLeft(_ + _))
  println(a.reduceRight(_ + _)) //还有从右侧执行

  val b = List(("a", 1), ("a", 1), ("a", 1), ("b", 1), ("b", 1), ("c", 1))
}
