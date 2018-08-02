package info.aoye.basic

/**
  * 1. import语句可以出现在任何地方,而不是只能在文件顶部.
  * 2. import的效果从开始延伸到语句块的结束.这可以大幅减少名称冲突的可能性.
  * 3. 默认情况scala总会引入java.lang._ scala._ 和 Predef._ 这里也能解释,为什么以scala开头的包,在使用时都是省去scala.
  * 注意:上述三个语句的顺序藏着一点玄机,我们知道,通常,如果import进来两个包都有某个类型的定义的话,比如说,同一段程序,
  * 即引用了'scala.collection.mutable.Set'又引用了'import scala.collection.immutable.Set'则编译器会提示无法确定用哪一个Set.
  * 这里的隐式引用则不同,如果有相同的类型,后面的包的类型会将前一个隐藏掉.
  * 比如java.lang和scala两个包里都有StringBuilder这种情况下会使用scala包里定义的那个.java.lang里的定义就被隐藏掉了,
  * 除非显示的使用java.lang.StringBuilder
  *
  * 4. 引入一个包的所有内容需要添加._ 标记, 例如scala.math._
  */

import java.lang._  //默认导入
import scala._      //默认导入
import Predef._     //默认导入: 包含大部分基本的转换

import scala.math._


/**
  * 1. scala程序的入口点,需要是object类型,然后里面有main方法
  * 2. scala程序的入口点,也可以直接继承App特质 object Test extends App
  * 3. object类型里面所有的成员都是静态的(scala 中的静态类)
  *
  * @since 那个版本
  */
object Main {

  /**
    * 1. 程序的入口点,仅带一个参数Array[String],且返回类型为Unit的单例对象
    * 2. 关键字def,定义方法或者是函数.
    * 3. 这里的main是方法,因为他不具备函数特征.
    * 4. Unit类型,类似于java中的void类型.
    * 5. = 符号表示main的方法体在等号的右边.
    * 6. 方法体一般用{}来封装,里面可以包含很多条语句.默认情况下,最后一条语句的结果类型就是代码块的返回类型.
    * 7. 技巧: 如果方法的返回类型是Unix,这时就可以省略定义结构中的" :Unit = "
    * 9. 说明: scala比较底层的内容会调用java来实现. IO 线程Thread 数据源等.
    * 10. 按照目前OS的原理,main入口方法都是运行在主线程中的. OS的运行分为Kernel Space 和User Space,应用程序是运行在UserSpace中的,应用程序Scala所在的进程一般都是透过OS Fork出来的,
    * 被Fork出来的应用程序进程默认会有主线程,而我们的main方法就是默认在主线程中的.
    * 11.
    *
    * @param args 参数名和参数类型,字符串数组
    */
  def main(args: Array[String]): Unit = {

    //赋值表达式的返回值是Unit类型,所以不能写作 val a = b =123,这里b=123返回的是Unit
    val str0 = "Hi!"

    //Scala中的数学方法
    println(sqrt(2)) //Stdout：1.4142135623730951


    //伴生对象(静态方法)
    //BigInt是一个类，使用BigInt的伴生对象的apply方法构建一个对象。
    import scala.math._
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

    // reduce 集合中第一个数减去第二个数, 结果再减去第三个数, 然后结果再减去第四个数... todo 默认就是reduceLeft??
    println((1 to 5).reduce(_ - _))
    println((1 to 5).reduce((a, b) => a - b))
    println((1 to 5).reduce((a, b) => {
      println(s"$a - $b")
      a - b
    }))

    // reduceLeft 集合中第一个数减去第二个数, 结果再减去第三个数, 然后结果再减去第四个数...
    println((1 to 5).reduceLeft(_ - _))
    println((1 to 5).reduceLeft((a, b) => a - b))
    println((1 to 5).reduceLeft((a, b) => {
      println(s"$a - $b")
      a - b
    }))

    // reduceRight 集合中最右边两个数相减(4-5), 然后右边第三个数减去这个结果, 然后右边第四个数再减去这个结果, ...
    println((1 to 5).reduceRight(_ - _))
    println((1 to 5).reduceRight((a, b) => a - b))
    println((1 to 5).reduceRight((a, b) => {
      println(s"$a - $b")
      a - b
    }))

    // foldLeft 提供一个初始值10 ,然后从集合左边开始操作, 10 - 第一个元素, 然后结果再减去第二个元素, 然后结果再减去第三个元素...
    // 实际效果: ( ( ( ( 10 - 1 ) - 2 ) - 3 ) - 4 ) - 5
    println((1 to 5).foldLeft(10)(_ - _))
    println((1 to 5).foldLeft(10)((a, b) => {
      println(s"$a - $b")
      a - b
    }))

    // foldRight 提供一个初始值, 然后集合最右边的元素减去10, 然后集合右边第二个元素减去前一步结果, 然后右边第三个元素减去前一步结果...
    // 实际效果: 1 - ( 2 - ( 3 - ( 4 - ( 5 - 10 ) ) ) )
    println((1 to 5).foldRight(10)(_ - _))
    println((1 to 5).foldRight(10)((a, b) => {
      println(s"$a - $b")
      a - b
    }))

    // collect 返回Vector(asdf)  这个里面其实就是一个偏函数
    println((1 to 5).collect {
      case 1 => "asdf"
    })

    // filter 过滤, 接收一个判断, 进行过滤
    println((1 to 5).filter(_ % 2 == 0))


    //todo 组装注入??
    //todo 胖接口和瘦接口!??
  }
}
