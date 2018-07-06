package info.aoye.basic.generic

/**
  * 泛型类
  * 用于指定类可以接受任意类型参数, 参数的类型在实际使用时才被确定, 泛型可以有效的增强程序的适应性, 使用泛型可以使得类或
  * 者方法具有更强的通用性.
  * 1. 定义类的时候, 在类的名字后面添加"类型参数"([A,B]) 表明对这个类的参数(主构造函数传递过来的对象类型)进行限定(界定).
  * 2. Animals类 的类型参数为[A,B] 限定参数类型为A和B类型类型.这个类的构造过程需要传递两个对象,一个A类型, 一个B类型
  * 3. 对于A 和 B 到底是什么类型需要在执行的时候才才能确定
  * 4. 在实际运行的时候会擦出这个类型参数, 仅在编译的时候有效.
  */
class Animals[A, B](val name: A, val age: B) {
  println(s"Name is : $name, Age is $age")
}

/**
  * 泛型类
  *
  * @param name 主构造函数,需要传递名称为name 类型为T的对象
  * @tparam T 类型参数为T, 运行的时候才能确定这个内容
  */
class Animals1[T](val name: T) {
  println("Wang wang!")
}

/**
  * 泛型类
  *
  * @param name 主构造函数,需要传递名称为name 类型为T的对象
  * @tparam String 类型参数为String, 界定这个参数必须是String类型
  */
class Animals2[String](val name: String) {
  println("Wang wang!")
}

class HospitalForDog {}

object GenericClass extends App {
  // 1. 在创建对象的时候指明[A, B] 为 [String, Int]
  val cat = new Animals[String, Int]("小猫", 23)
  println(cat.getClass) //class info.aoye.basic.generic.Animals

  // 2. 在创建对象的时候指明[A, B] 为 [String, String]
  val dog = new Animals[String, String]("小狗", "55")
  println(dog.getClass)

  // 3. 在创建对象的时候不指明[A, B] 为的类型, 这是就可以传递任意类型进去.
  val goldFish = new Animals("金鱼", ("dd", "ddd"))
}
