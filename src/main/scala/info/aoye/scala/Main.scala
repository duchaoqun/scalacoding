package info.aoye.scala

//注意:import语句可以出现在任何地方,而不是只能在文件顶部.import的效果从开始延伸到语句块的结束.这可以大幅减少名称冲突的可能性.
//注意:默认情况下,scala总会引入java.lang._ scala._ 和 Predef._ 这里也能解释,为什么以scala开头的包,在使用时都是省去scala.的

import java.util.{HashMap => JavaHashMap} //隐藏成员,引入了util包的所有成员,但是HashMap被隐藏了.

import info.aoye.test.TestImplicit

import scala.math._


/**
  * 1. scala程序的入口点,需要是object类型,然后里面有main方法
  * 2. scala程序的入口点,也可以直接继承App特质
  *
  * @since 那个版本
  */
object Main {

  //程序的入口点
  def main(args: Array[String]): Unit = {
    val test1 = new TestImplicit
    implicit val currentTaxRate = 0.08F
    println(test1.calcTax(5000F))

    // Scala中的数学方法
    println(sqrt(2)) //Stdout：1.4142135623730951


    // 伴生对象(静态方法)
    // BigInt是一个类，使用BigInt的伴生对象的apply方法构建一个对象。
    print(BigInt(123) * BigInt(123))
    val array1 = Array(1, 2, 3, 4) //Array类的伴生对象

    //TODO: Scala 记录日志相关内容补充

    //TODO: map 方法学习
    //TODO: reduce 方法学习


    //关于方法的调用
    //1. 如果方法不需要参数，那么可以省略括号
    val value1: String = "5".toString()
    val value2: String = "5".toString
  }
}
