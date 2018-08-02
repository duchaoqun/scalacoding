package info.aoye.basic.generic

/**
  * 类型参数界定 Type Variable Bound
  * 上边界 对 类型的限定:必须为某种类型 或者某种类型的子类.  <:
  */

class TypeVariableBound{

  /**
    * 有时候我们需要对变量类型进行限制
    * 如果直接使用[T]来限定, 我们并不知道类型T到底有没有compareTo方法
    * 这是就需要添加一个上边界, 界定T 必须是Comparable 或者其子类型, 这样它就有compareTo方法了
    * @param first Comparable 或者其子类型的参数
    * @param second Comparable 或者其子类型的参数
    * @tparam T 上边界类型参数, 表示Comparable或者其子类型
    */
  def compare[T <: Comparable[T]](first:T, second:T):Unit = {
    if( first.compareTo(second) > 0) first else second
  }
}

object TypeVariableBound{
  def main(args:Array[String]) : Unit = {
    val tvb = new TypeVariableBound
    println(tvb.compare("A","A"))
  }
}
