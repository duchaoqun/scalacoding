package info.aoye.scala.TestTrait

/**
  * 1. 这里的trait字面意思是特质或者特征,这个词翻译成特征比较合适.它的意义和java,c#中接口很类似.
  * 2. Trait可以被作为接口来使用,此时Trait与Java的接口非常类似.
  * 3. Scala同Java一样,不支持类多继承,但支持多重继承Trait,使用with关键字即可.
  * - 注意：类使用extends继承Trait,与Java不同,这里不是implement,在Scala中,无论继承类还是继承Trait都是用extends关键字.
  * 4. 在Trait中定义具体属性：在Scala中，Trait可以定义具体属性，继承Trait的类就自动获取了Trait中定义的属性.
  * - 注意：这里与继承Class不同，如果继承Class获取的字段，实际定义在父类中，而继承Trait获取的字段，就直接添加到了类中.
  * 5. 在Trait中可以定义抽象字段,而Trait中的具体方法可以基于抽象字段来编写,但继承Trait的类,则必须覆盖抽象的field,提供具体的值.
  *
  * 应用场景：Trait中可以包含很多类都通用的功能,如打印日志
  */

object TestTrait extends scala.App {
  //Man对象,Trait的基本信息
  val man1 = new Man
  man1.say("")
  man1.eat("")

  //创建dog对象的时候,可以"混入"某个特质.这样只有这个对象混入了该Trait,其他对象则没有.
  val dog1 = new Dog with Mouth{
    override val size: String = "又长又大" //必须实现的字段
    override def say(message: String): Unit = {println("旺旺!")}
    override def eat(message: String): Unit = {println("狗粮狗粮!")}
    look("嘴巴看起来很丑陋!")
  }
  dog1.say("")
  dog1.eat("")

  //todo https://blog.csdn.net/Godfrey1/article/details/70316850
  val boy1 = new Boy
}