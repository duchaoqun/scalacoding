package info.aoye.basic.TestImplicit

/**
  * 隐式对象
  * 1. 隐式类需要放置在类里面,不能直接放在package里面.
  * 2. 需要放在object里面
  * 3. 在使用的时候直接 import Implicits._
  * 4. 隐式类的运作方式是: 隐式类的主构造函数只能有一个参数(有两个以上并不会报错,但是这个隐式类永远不会被编译器作为隐式
  *    类在隐式转化中使用),且这个参数的类型就是将要被转换的目标类型.从语义上这很自然:
  *    这个隐式转换类将包裹目标类型,隐式类的所有方法都会自动"附加"到目标类型上.
  */
object Implicits {

  /**
    * 隐式方法
    * Animals类没有Cat类中的方法, 在创建Animals对象时, 引入这个隐式转换, 然后调用 Cat中的方法即可.
    * 相当于将Cat的方法扩展给了这个Animals对象. 还是直接转换了类型??
    * @param animals 需要扩展方法的对象
    * @return 返回一个拓展的对象.
    */
  // 技巧B: 创建一个隐式转换类, 里面单独存放隐式转换的内容.
  implicit def animalsToCat(animals: Animals) = new Cat(animals.name)

  /**
    * 隐式类
    * 对类的加强? 拓展了目标的方法,实现类的增强和扩展.
    * 如下,如果那个类引入了此隐式类,当执行Int类型对象时,就多了一个方法!
    * @param int1 扩展的目标对象
    */
  implicit class ImpInt(int1: Int) {
    // 被引用的地方,可以使用 123.add 方法,这样就扩展了原有的内容
    def add(int2: Int) = int1 + int2
  }

  implicit class TmpString(str: String) {
    def str2int(str: String) = str.toInt
  }
}
