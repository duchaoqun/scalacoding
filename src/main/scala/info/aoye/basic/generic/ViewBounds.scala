package info.aoye.basic.generic

/**
  * scala 类型系统编程
  * 3. View Bounds 视图界定, 可以进行某种神秘的转换, 把你的类型可以在没有直觉的情况下, 转换成为目标类型. <%
  *    其实你可以认为View Bounds是上边界和下边界的加强补充版本.
  *    例如在SparkContext这个核心类中,有 T <% Writable 方式的代码, 这个代码所表达的是T 必须是Writable类型的, 但是T没有
  *    直接继承自Writable接口, 此时就需要通过"implicit"的方式来实现这个功能.
  */
object ViewBounds extends App {
  class Person(val name:String){
    def talk(person:Person): Unit ={
      println(this.name + " : " + person.name)
    }
  }
  class Worker(name:String) extends Person(name){}
  class Dog(val name:String){}

  // 已经过时的内容
  class Club[T <% Person](p1:T,p2:T){
    def communicate():Unit = p1.talk(p2)
  }
  // 定义隐式转换来支持这个操作
  implicit def dog2Person(dog:Dog) = new Person(dog.name)
  val w = new Worker("Spark")
  val d = new Dog("Dog")

  // todo? 这里需要定义Person泛型来限定,后续需要继续深入学习.
  new Club[Person](w,d).communicate()
}
