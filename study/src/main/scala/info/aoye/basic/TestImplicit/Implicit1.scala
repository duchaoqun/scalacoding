package info.aoye.basic.TestImplicit

class Animals(val name: String) {}

object Animals {
  // 技巧A 在伴生对象中创建隐式转换, 来实现对象类型的转换.
  implicit def animalsToDog(animals: Animals) = new Dog(animals.name)
}

class Dog(val name: String) {
  def say(): Unit = println(this.name + " Wang Wang Wang!!!")
}

class Cat(val mame: String) {
  def say(): Unit = println(this.mame + " Mo Mo Mo!!!")
}

object Implicit1 extends scala.App {
  val animals_1 = new Animals("Animal_Dog_1")
  animals_1.say() // IDEA提示带有下划线,说明这个方法是(伴生对象里)隐式转换过来的.

  // 技巧B: 创建一个隐式转换类, 里面单独存放隐式转换的内容. 然后再需要的时候导入
  import info.aoye.basic.TestImplicit.Implicits._

  val animals_2 = new Animals("Animal_Cat_1")
  animals_2.say()

  // 技巧C: 隐式参数, 给一个方法提供默认参数? 用作默认配置是非常有用的.
  implicit val dns = "8.8.8.8"
  def ifConfig(ip:String)(implicit dns:String): Unit ={
    println(s"My ip is :$ip and DNS is $dns")
  }
  ifConfig("172.17.2.16")
  ifConfig("172.17.2.17")("114.114.114.114")

  //implicitly //todo 这个是干什么用的?
}
