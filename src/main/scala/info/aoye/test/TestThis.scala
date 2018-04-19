package info.aoye.test

class TestThis {
  var id: Int = 0
  var name: String = ""

  //TODO：这里的构造函数就是空的，默认是this？
  //辅助构造函数，接受两个对象
  def this(id: Int, name: String) {
    this() //调用默认构造函数，第一行必须写这个 调用主构造函数
    this.id = id
    this.name = name
  }

  def show() {
    println(id + " " + name)
  }
}

//主构造函数:直接定义在类定义上
class TestPerson(name: String) {

  //重写主构造函数，看起来没什么意义？
  //  def this(){
  //    this(name.dropRight(1))
  //  }
  //辅助构造函数
  def this(name: String, age: Int) = {
    this(name)
    println(name + age)
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val a = new TestThis(1, "duchaoqun")
    a.show()

    val b = new TestPerson("asdf", 123)
  }
}
