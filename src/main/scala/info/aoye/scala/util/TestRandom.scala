package info.aoye.scala.util

import scala.util.Random

/**
  * scala生成随机数
  */
object TestRandom extends scala.App {

  //构造对象 todo: 咋用?
  val random1 = new Random()
  val random2 = new Random(10)
  val random3 = new Random(Long.MaxValue)

  //单例对象(object) 常用方法
  println(Random.alphanumeric)   //collection.immutable.Stream[Char] 随机字符?
  println(Random.nextBoolean)    //随机true and false
  println(Random.nextBytes(Array('a','d','c','d','e')))  //随机数组里面的字符??? todo 待研究
  println(Random.nextFloat)      //0-1之间的浮点数
  println(Random.nextDouble)     //0-1之间的浮点数
  println(Random.nextInt(100))   //生成100以内的随机数
}
