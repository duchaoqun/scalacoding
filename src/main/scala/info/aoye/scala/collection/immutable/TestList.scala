package info.aoye.scala.collection.immutable

/**
  * 列表用来保存一组对象,可以是相同类型,也可以是不同类型
  * 列表的值是不可变的,个别时候只是取了原来列表的值返回新创建的一个列表
  */
object TestList extends scala.App {

  // 创建列表
  val list1 = Nil //定义一个空列表
  val list2: List[Int] = Nil //定义一个Int类型的列表(使用泛型),空列表
  val list3 = List(1, 2, 3) //定义一个Int类型的列表,并初始化值
  val list4 = List(4, 5, 6)
  val list5 = List("A", "B", "C")
  val list6: List[Map[String, String]] = Nil  //定义其他对象的列表
  val list7 = List(1,2,3,"44","55","66")


  // 在列表中添加新对象
  // 该操作将一个新对象添加到本列表的最前面
  // 注意：需要定义一个新的List接收返回值
  println(list3 :: list4) // List(List(1, 2, 3), 4, 5, 6)
  println(0 :: list4) // List(0, 4, 5, 6)

  // 将一个对象添加列表最后面
  println(list4 :+ 7) // List(4, 5, 6, 7)

  // 该操作符拼接两个List
  println(list3 ::: list4) // List(1, 2, 3, 4, 5, 6)


  // 访问列表里面的内容 常用操作
  println(list4(0)) //返回列表中坐标为0的值,列表以0开始。

  // 常用操作
  list5.drop(1) //删掉最前面的一个元素,最左边
  list5.dropRight(1) //删掉最后面的一个元素,最右边
  list5.head //返回列表的第一个对象
  list5.last //返回列表的最后一个元素
  list5.tail //返回除列表第一个元素组成的新列表
  list5.init //返回除列表最后一个元素组成的新列表

  // 其他待研究
  list5.count(a => a.length == 1) //计算列表中字符长度为1的元素个数, 遍历列表？ 传递给a？ 判断a的长度？
  list5.exists(s => s == "B") //判断“B” 是否在列表里面,如果在返回true
  list5.filter(s => s.length == 2) //过滤列表中的内容,将长度为2的取出来,返回一个新列表
  list5.forall(s => s.endsWith("C")) //判断列表里面的元素是否都是以C结尾
  list5.foreach(s => print(s)) //对列表中的每个字符执行print
  list5.foreach(print) //对列表中的每个字符执行print
  list5.isEmpty //判断列表是否为空
  list5.length //列表长度
  list5.map(s => s + "D") //返回列表每个元素都+D的新列表
  list5.mkString(",") //将列表组成字符串,用逗号分隔
  list5.reverse //返回倒序新列表

  //排序
  val list8: List[Int] = List(5, 7, 9, 3, 1, 2, 3, 4)
  println(list8.sortWith((x, y) => x > y))  //List(9, 7, 5, 4, 3, 3, 2, 1) 使用自己定义的方法进行,可以对复杂对象排序
  println(list8.sorted)
  println(list8.sum)  //计算列表中所有数字的和
}
