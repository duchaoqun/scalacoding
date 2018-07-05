package info.aoye.scala.TestClass

/**
  * 继承: 实现代码复用,通用代码使用父类来做,如果需要修改的话,只需要修改父类就可以了,子类无需变化.
  * 1. 父类一般都是抽象的。
  * 2. 父类的方法，大部分子类都可以直接使用，部分会有权限的问题。
  * 3. 类继承的时候，会不会继承它的伴生对象？不会的。
  * 4. 抽象方法必须实现其代码，实现方法或者复写方法必须使用override关键字，方便自己，方便他人。
  * 5. 调用父类方法直接使用super既可！？？？？？
  * 6. 父类型的对象，转换成子类型的对象？？？
  * 7. isInstanceOf 和 asInstanceOf 和 getClass 和 classOf
  */
class FatherClass {

}
