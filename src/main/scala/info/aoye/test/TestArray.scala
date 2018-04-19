package info.aoye.test

// 如下两种引用方法,默认是不需要写的,程序默认就引用了.
import Array._
import scala.Array._

/**
  *
  */
object TestArray extends scala.App {

  //定长数组，有10个元素，默认都是0
  val num_1 = new Array[Int](10) //10个Int值,默认都是0
  val num_2 = new Array[String](10) //10个String值,默认都是Null
  val num_3 = Array("abc", "def") //当提供已知值的时候(实际调用伴生对象的apply方法)，就不需要new关键字了.
  val num_4 = Array.apply("abc", "def") // 使用伴生对象的apply方法创建对象.
  val num_5: Array[String] = new Array[String](10) //规范的写法,加[]使用类型参数.


  println(num_3) //todo 默认这里是调用toString方法? [Ljava.lang.String;@55d56113


  //修改值：
  //1.下标从0开始
  //2.使用() 而不是使用[]
  num_3(0) = "ddd"

  //变长数组：ArrayBuffer
  //1.下标从0开始
  import scala.collection.mutable.ArrayBuffer

  //如下两个是等效的，一个空的数组缓冲
  val ab1 = ArrayBuffer[Int]()
  val ab2 = new ArrayBuffer[Int]()

  //在后面添加一个元素
  ab1 += 1
  //在后面添加一个多个元素
  ab1 += (2, 3, 4, 5)
  //追加任何集合？ TODO 有待进一步学习
  ab1 ++= Array(6, 7, 8, 9)
  //常用：去掉后面的5个元素
  ab1.trimEnd(5)
  //在下标2之前插入6,其他后移
  ab1.insert(2, 6)
  //在下标2位置上插入多个元素
  ab1.insert(2, 6, 7, 8)
  //删除下标是2的元素
  ab1.remove(2)
  //从下标2开始删除3个元素
  ab1.remove(2, 3)

  //在缓冲准备完整之后，使用toArray转换成数组来使用
  ab1.toArray
  //也可以直接把数组改变成Buffer进行操作
  num_3.toBuffer
}
