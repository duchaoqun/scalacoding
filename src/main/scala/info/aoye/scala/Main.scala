package info.aoye.scala

//注意:import语句可以出现在任何地方,而不是只能在文件顶部.import的效果从开始延伸到语句块的结束.这可以大幅减少名称冲突的可能性.
//注意:默认情况下,scala总会引入java.lang._ scala._ 和 Predef._ 这里也能解释,为什么以scala开头的包,在使用时都是省去scala.的

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

    //Scala中的数学方法
    println(sqrt(2)) //Stdout：1.4142135623730951


    //伴生对象(静态方法)
    //BigInt是一个类，使用BigInt的伴生对象的apply方法构建一个对象。
    println(BigInt(123) * BigInt(123))

    //TODO: reduce 方法学习


    //关于方法的调用
    //1. 如果方法不需要参数，那么可以省略括号
    val value1: String = "5".toString()
    val value2: String = "5".toString


    /**
      * 1. map 对集合中的每一个元素进行操作,然后返回一个结果,这个结果组成一个集合.
      * 2. 如果这个集合的内容是"集合对象",我们还想获取集合
      */

    //定义一个Person类.
    case class Person(name: String, friends: List[String])

    //构建三个Person对象,每个人都有不同的朋友.
    val p1 = Person("John", List("JohnFriendA"))
    val p2 = Person("Chris", List("ChrisFriendA", "ChrisFriendB"))
    val p3 = Person("Mary", List("MaryFriendA", "MaryFriendB", "MaryFriendC"))

    //构建一个Person列表.
    val listPerson: List[Person] = List(p1, p2, p3)

    //map 将集合中的每个对象序列
    //返回的是List(List(JohnFriendA), List(ChrisFriendA, ChrisFriendB), List(MaryFriendA, MaryFriendB, MaryFriendC))
    def map_1(): Unit = {
      val res = listPerson.map(x => x.friends)
      println(res)
    }

    //flatMap 将集合第二层对象序列
    //返回的是List(JohnFriendA, ChrisFriendA, ChrisFriendB, MaryFriendA, MaryFriendB, MaryFriendC)
    def flat_map(): Unit = {
      val res = listPerson.flatMap(x => x.friends)
      println(res)
    }

    map_1()
    flat_map()
  }
}
