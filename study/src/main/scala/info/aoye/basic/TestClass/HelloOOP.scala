package info.aoye.basic.TestClass

/**
  * 伴生类
  * 在scala中可以使用class来定义一个类
  * 1. 可是使用new class的方式来构建一个对象.
  * 2. 如果名称相同,则object中的内容都是class的静态内容.也就是说Object中的内容,class都可以在没有实例的时候直接调用.
  * 正式因为可以在没有类的实例的时候,可以直接调用object中的一切,所以可是使用object中的特定方法来创建实例,这个特定方法就是apply
  * 3. object中的apply方法是class对象生成的工厂方法,用来控制对象的生成.
  * 4. 很多框架的代码,一般直接调用抽象类的object的apply方法去生成类的实例对象:
  * 其一:秘诀在于apply具有类的对象生成的一切的生杀大权,抽象类是不可以直接实例化的,在apply方法中可以实例化抽象类的子类.以SPark中的图计算为例,Graph是抽象class,在object Graph中的apply方法实际上是调用了Graph的子类GraphImpl来构建Graph类型的对象实例的,当然Spark图计算的源代码可以看出,GraphImpl的构造也是使用了object GraphImpl的apply方法.
  * 其二:这种方式的神奇的效应在于,更加能够应对代码版本迭代或者修改的变化.这个是更高意义的面向接口编程. TODO://这个需要深入学习.
  * 5. 伴生类和伴生对象可以互相访问其成员?
  * 6. 在定义scala的class的时候,可以直接在类名后面()加入类的构造参数,此时在apply的方法中也必须有这些参数.
  * 7. scala中可以在object中构造很多apply方法!!
  * 8. scala中的很多集合都是使用apply的方式构造的,例如Array
  */
class HelloOOP(val age: Int) {  //todo 留意主构造函数中的val 修饰符, 表示这个成员可以直接使用!??
  var name = "Spark"

  def sayHello(): Unit = println("Hi my name is " + name + ", and my age is " + age)
}

/**
  * 伴生对象
  * 1. 在API设计的时候,如果将要过期的方法,可以将会变动的内容放到object里面,方便版本的迭代.
  */
object HelloOOP {
  def main(args: Array[String]): Unit = {
    println("Hello scala OOP!")
    val hello = HelloOOP(30)
    hello.sayHello()
  }

  // 第一个apply方法
  def apply(age: Int): HelloOOP = {
    new HelloOOP(age)
  }
  // 第二个apply方法, todo: 后续继续学习重载构造方法.
  def apply(): HelloOOP = new HelloOOP(10)
}
