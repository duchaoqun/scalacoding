package info.aoye.basic.generic

/**
  * T:ClassTag, 例如Spark源代码中的 Class RDD[T:ClassTag] 这个其实也是一种类型转换系统, 只是在编译的时候类型信息不够,
  * 需要借助于JVM的runtime来通过运行时信息获得完整的类型信息, 这在Spark中是非常重要的, 因为Spark的程序的编写和运行是
  * 区分了Driver 和 Executor的, 只有在运行的时候才知道完整的类型信息.
  *
  * 逆变和协变: -T 和 +T
  *
  * Context Bounds T;Ordering
  */

class Engineer

class Expert extends Engineer

class Meeting[-T]

object TestClassTag {

}
