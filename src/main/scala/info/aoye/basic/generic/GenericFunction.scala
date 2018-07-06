package info.aoye.basic.generic

object GenericFunction extends App {

  /**
    * 泛型函数
    * @param pSrc 参数的类型为Array 里面包含的是T 类型的对象
    * @tparam T 类型参数(泛型)为 T , 用来界定参数中Array内容的类型
    * @return 将Array类型转换成List类型
    */
  def asList[T](pSrc: Array[T]): List[T] = {
    if (pSrc == null || pSrc.isEmpty) {
      List[T]()
    } else {
      pSrc.toList
    }
  }

  val friends = Array("小白", "琪琪", "乐乐")
  println(friends.getClass)        //class [Ljava.lang.String;
  val friendList = asList(friends)
  println(friendList.getClass)     //class scala.collection.immutable.$colon$colon
  println(friendList.isInstanceOf[List[String]])
}
