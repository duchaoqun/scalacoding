package info.aoye.scala.TestImplicit

/**
  * 用来格式化对象的类
  *
  * @param left  左边需要添加的字符
  * @param right 右边需要添加的字符
  */
class OutputFormat(var left: String, val right: String)


/**
  * 实体类1,不包含隐式参数的方法
  *
  * @param name 构造的时候需要名字
  */
class Student1(var name: String) {
  //将Student类的信息格式化打印
  def formatStudent(outputFormat: OutputFormat): String = {
    outputFormat.left + " " + this.name + " " + outputFormat.right
  }
}

/**
  * 实体类2,包含隐式参数
  *
  * @param name 构造的时候需要的名字
  */
class Student2(var name: String) {
  //定义一个方法,包含一个隐式参数
  def formatStudent()(implicit outputFormat: OutputFormat): String = {
    outputFormat.left + " " + this.name + " " + outputFormat.right
  }
}

object TestWithImp extends scala.App {
  //一般情况,正常声明一个对象
  val outputFormat1 = new OutputFormat("<<", ">>")
  //一般情况,正常传入对象
  println(new Student1("Ga").formatStudent(outputFormat1))

  //隐式方式,定义一个"隐式值": outputFormat,隐式值可以用于给方法提供参数
  implicit val outputFormat2 = new OutputFormat("<<", ">>")
  //隐式方式,在调用formatStudent()方法时,编译器会在当前上下文查找符合的隐式参数类型对象(outputFormat2),直接传递给对应方法
  println(new Student2("Du").formatStudent())
}
