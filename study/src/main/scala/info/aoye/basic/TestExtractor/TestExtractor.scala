package info.aoye.basic.TestExtractor

case class Person(name: String, age: Int)

class Person1(name: String, age: Int) {}

object Person1 {
  /**
    * 自定义工厂方法
    * @param name
    * @param age
    * @return
    */
  def apply(name: String, age: Int): Person1 = new Person1(name, age)

  /**
    * 自定义提取器?
    * @param arg 将会被提取的内容
    * @return 返回一个Some对象,提取出内容放到一个二元Tuple里面
    */
  def unapply(arg: String): Some[(String, String)] = {
    Some((arg.substring(0, arg.indexOf(" ")), arg.substring(arg.indexOf(" ") + 1)))
  }
}

object TestExtractor extends scala.App {
  val person = Person("duchaoqun", 28) //调用apply工厂方法创建对象
  val Person(name, age) = person //调用unapply方法把person实例中的属性提取出来,todo 提取出来放到当前对象里面吗(作为当前对象属性)?

  println(s"My name is : $name and age is :$age")

  person match {
    case Person(name, age) => println(s"My name is : $name and age is :$age") //实际模式匹配对象就是使用的提取器
  }

  val Person1(name1,age1) = "Hello World!"
  println(name1 + age1)
}
