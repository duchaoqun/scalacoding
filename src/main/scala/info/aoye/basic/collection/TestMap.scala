package info.aoye.basic.collection

import scala.collection.mutable

/**
  * trait 和 object， 是一个特质和单例对象
  * 1. 可以使用mutable 可变的Map
  * 2. 可以使用immutable 不可变Map
  * 3. Map里面的每项内容实际上是一个二元组
  *
  * http://www.scala-lang.org/api/2.12.3/scala/collection/mutable/Map.html
  */
object TestMap extends scala.App {
  // 1. 默认情况下Map构造函数是不可变的集合,里面的内容不可以修改,一旦修改就变成了新的Map,原有的Map内容保持不变. //import scala.collection.immutable.Map  //不可变
  // 2. Map的实例是调用工厂方法的apply来构造Map实例的,
  val bigData = Map("Spark" -> 666, "Hadoop" -> 888)

  // 3. 使用可变的map,需要导入可变的包. //import scala.collection.mutable.Map  //可变
  val programLanguage = scala.collection.mutable.Map("Scala"->123,"Java"->456)
  programLanguage("Scala")=88888
  for((name,value)<- programLanguage) println(name + value)

  // 4. 如果想直接new出Map实例,则需要使用HashMap等具体的Map子类;
  var map1 = Map[Int, String]() //定义一个空的Map，必须使用范型控制Map的类型
  var map2 = Map[String, String]() //定义一个空的Map对象，必须使用范型空置Map的类型
  val mapA = new scala.collection.mutable.HashMap[String,Int]
  var map3 = Map("France" -> "Paris", "Japan" -> "Tokyo", "China" -> "Beijing") //定义初始值的Map
  var map6 = Map(("France", "Paris"), ("Japan", "Tokyo"), ("China", "Beijing")) //定义初始值的Map
  var map4 = Map[Int, Map[String, String]]() //复杂的Map对象
  val map5 = Map[String, Any]() //复杂的Map对象

  // 注意:直接使用key值进行获取value,如果不存在会报错, 这里尽量使用getOrElse, 还可以设置默认值, 这非常有用.
  //println(map1(1)) //println(map1(4))  key not found! Error
  println(map1.getOrElse(4, "Not Found!")) //优雅的获取值，如果不存在就返回第二个内容
  println(map1.getOrElse(4, "Not Found!").asInstanceOf[String]) //获取内容,并转换成指定类型的对象.

  //向Map里面添加和删除内容,注意定义的时候需要引用可变的Map类
  map1 += (1 -> "The First!")
  map1 += (2 -> "The Second!")
  map1 += (3 -> "The Thrid!")
  map1 += (4 -> "Four")
  map1 += (4 -> "The Fourth") //如果存在，会覆盖原来的值
  map1 -= (3) //删除内容,这里不需要括号.
  map1 -= 4 //删除内容
  //Int值1调用 -> 方法(1).->("The First!") 返回包含一个键值对的二元组。
  //map1调用 +=方法，接收上面的二元组  map1.+=(二元组)
  //Scala任何对象都能调用->方法，这个机制被称为隐式转换。

  // 交换Key和Value的位置.
  val result = for((key,value)<- map1) yield (value,key)
  println(result)

  // 使用排序的HashMap.留意大小写.
  val sortedMap = scala.collection.immutable.SortedMap(("Alic",30),("John",44),("Chris",88))
  for((key,value)<-sortedMap) println(key + value)

  // LinkedHashMap可以记住插入的数据的顺序,这个是非常有用的内容.
  val linkedMap = scala.collection.mutable.LinkedHashMap(("Alic",30),("John",44),("Chris",88))
  for((key,value)<-linkedMap) println(key + value)

  println(map1.contains(1)) //判断是否存在Key值
  println(map1.size) //打印大小
  println(map1.isEmpty) //判断是否为空

  map1.keys.foreach(println) //只打印key
  map1.values.foreach(println) //只打印value

  //map1 = Map() //清空Map

  // 使用for遍历一个Map对象
  for ((k, v) <- map1) {
    print(k + "-->")
    println(v)
  }

  // 使用foreach 遍历对象
  map1.foreach {
    case (e, i) => println(e, i)
  }

  //
  map1.toSeq.sortBy(_._1) //升序排序 key   返回ArrayBuffer
  map1.toSeq.sortBy(_._2) //升序排序 value
  map1.toSeq.sortWith(_._1 > _._1) //降序排序 key
  map1.toSeq.sortWith(_._2 > _._2) //降序排序 value

  //转换
  //List对象类表转换成Map
  val list1 = List(1, 2, 3, 4, 5)
  val list1ToMap1 = list1.map(
    x => (x -> x.toString)
    //x => (x , x.toString)  //注意这里，使用逗号和 -> 都可以？
  ).toMap

  //如果list里面是复杂的对象，就可以将每个对象封装到一个Map中。
  val list1ToMap2 = list1.map(
    x => Map(x -> "aaa")
  )

}
