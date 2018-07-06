package info.aoye.basic.TestTrait

/**
  * 定义类继承Trait,使用extends关键字,继承多个Trait在继续使用with关键字.
  * 注意:使用override关键字.
  */
class Man extends Mouth {
  //必须实现所继承Trait中的抽象字段.
  override val size: String = "很大"

  //所继承的Trait中已经定义的字段,这里直接调用.
  //注意,如果是继承自Class中的属性,该属性实际定义在父类中.但是继承自Trait的话,实际上就是把字段添加到本类中.
  println("我是男人,通常情况下我的嘴是" + this.status + "的.")

  //实现特质中的方法.
  override def say(message: String): Unit = {
    println("我是男人,通常我的话很少")
  }

  //重写(覆盖)特质中的方法.
  override def eat(message: String): Unit = {
    println("我是男人,我的嘴巴" + size + "我可以吃很多东西!")
  }

  //Trait里面的方法可以直接使用.
  look("嘴巴看起来真不错!!")
}
