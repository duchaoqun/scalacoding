package info.aoye.scala

object TestProduct extends scala.App {
  val list1 = (1,2,3)
  val list2 = (4,5,6)

  val product_1 = new Product2[List,List] {}

  println(product_1)
}
