package info.aoye.scala

/**
  * scala中使用数组,数据的集合,对数据的集合的操作等.
  * 说明:数据集合,会涉及数据的搜集,存储等,数据搜集有很多技术,数据存储当前使用Hadoop
  * 说明:对数据集合的操作技术,目前最火的就是Spark.
  * 说明:Spark中对很多数据的操作的算子和Scala中队集合的操作的算子是一样一样的,所以掌握Scala的集合操作很重要,便于学习Spark开发.
  * 1. 默认Scala程序都回引用Array包
  * 2. 关于Array本身在底层实现是借助JVM平台上的Java语言实现的,是不可变的!!! 注意:虽然元素不能删减! 但是我们可以修改元素的内容!!!
  * 3. 如果我们想使用可变数组的话,首先需要导入scala.collection.mutable.ArrayBuffer, 然后使用ArrayBuffer这个可变数组.
  * 4. 关于ArrayBuffer增加元素,默认都是在末尾增加元素的,所以效率非常高.
  */
object TestArray extends scala.App {
  //注意: 数组必须声明类型.

  // 案例A: 最原始的声明方式.
  //1. 定长数组,有10个元素,默认都是0,
  //2. 对数组的访问的时候,下标的返回时0到length-1 ,超过length-1会出现数组越界的错误.
  val num_1 = new Array[Int](10) //10个Int值,默认都是0
  val num_2 = new Array[String](10) //10个String值,默认都是Null
  num_1(0) = 123 //赋值
  //num_1(10) = 123 //数组下标越界ArrayIndexOutOfBoundsException
  for (item <- num_1) println(item)

  // 案例B: 最常用和经典的创建数组的方式.
  val num_3 = Array[String]("abc", "def")
  val num_4 = Array[Int](1, 2, 3, 4, 5) // 不使用apply
  val num_5 = Array(1, 2, 3, 4, 5) // 不使用apply,这里可以去掉泛型,是因为scala的类型推倒能力.
  val num_6 = Array.apply(1, 2, 3, 4, 5) // 使用Array的工厂方法模式创建,这里不用声明类型


  // 案例C: 可变的数组
  import scala.collection.mutable.ArrayBuffer

  //如下两个是等效的，一个空的数组缓冲
  val ab1 = ArrayBuffer[Int]()
  val ab2 = new ArrayBuffer[Int]()

  ab1 += 1 //在后面添加一个元素
  ab1 += (2, 3, 4, 5) //在后面添加一个多个元素
  ab1 ++= Array(6, 7, 8, 9) //追加任何集合？ TODO 有待进一步学习
  ab1.trimEnd(5) //常用：去掉后面的5个元素
  ab1.insert(2, 6) //在下标2之前插入6,其他后移
  ab1.insert(2, 6, 7, 8) //在下标2位置上插入多个元素
  ab1.remove(2) //删除下标是2的元素
  ab1.remove(2, 3) //从下标2开始删除3个元素
  ab1.sum //计算集合元素内的和.
  ab1.max //计算集合元素内最大值.
  ab1.toArray //在缓冲准备完整之后，使用toArray转换成数组来使用,变成不可变内容
  num_3.toBuffer //也可以直接把数组改变成Buffer进行操作


  // 案例D :遍历数组
  val array1 = Array(1, 2, 3, 6, 5, 4)
  // 简单排序
  scala.util.Sorting.quickSort(array1) //对数组进行快速排序
  println("quickSort = " + array1.mkString("######", ",", "######"))

  // 对已有的数组,通过对已有的元素进行操作,然后生成一个新的数组,可以使用yield关键字来实现.
  // 1. 他是在不修改已有的Array数据元素的基础上实现的,非常适合大数据的处理
  // 2. Spark在大数据处理中,业务核心就类似于yield,,通过使用function对每个元素进行操作,来构成新的集合(RDD),
  val array1AddOne = for (item <- array1) yield item + 1
  println("array1AddOne = " + array1AddOne.mkString("######", ",", "######"))

  // 守卫判断
  val array1AddEven = for (item <- array1 if item % 2 == 0) yield item
  println("array1AddEven = " + array1AddEven.mkString("######", ",", "######"))

  // 集合的filter函数
  println(array1.filter(item => item % 2 == 0).mkString(",")) //使用Array的filter函数.
  println(array1.filter(_ % 2 == 0).mkString(",")) //使用Array的filter函数.简写方式,使用下划线.

  // 集合的map函数
  println(array1.filter(_ % 2 == 0).map(item => item * 10).mkString(",")) //使用Array的map函数.简写方式.
  println(array1.filter(_ % 2 == 0).map(_ * 10).mkString(",")) //使用Array的map函数.简写方式,使用下划线.

  // 集合的zipAll函数
  val array2 = Array(4, 5, 6)
  array1.zipAll(array2, 0, 0).map(x => println(x))
  val c = array1.zipAll(array2, 0, 0).map((x_w) => x_w._1 * x_w._2).sum / 3.toFloat

}
