package info.aoye.basic.TestTrait

/**
  * 定义一个Trait
  */
trait Mouth {
  //在Trait中定义属性(不包含值)需要在子类提供实现的值. 这就是抽象的属性
  val size: String  //大嘴 小嘴

  //在Trait中定义属性(含值)
  val status: String = "关闭"  //默认嘴可以都是闭着的.

  //在Trait中定义抽象方法(不包含实现代码),与抽象类中的抽象方法一样,不给出方法的具体实现,该方法必须在子类中实现方法体.
  def say(message: String) {} //可以说话,不会说话,动物叫声

  //在Trait中定义抽象方法(包含实现代码),可以不在子类中实现该方法,直接调用.
  def eat(message: String): Unit = { //所有的嘴都可以吃东西.
    println("可以吃东西.")
  }

  //在Trait中定义抽象方法(包含实现代码),可以不在子类中实现该方法,直接调用.
  def look(message:String):Unit = {
    println(message)
  }
}
