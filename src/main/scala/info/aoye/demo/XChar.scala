package info.aoye.demo

/**
  * 获取单个字符的列表
  *
  * @param char 默认构造
  */
class XChar(char: Char) {
  val charM:Char = char


  /**
    * 默认的toString方法
    * @return
    */
  override def toString: String = charM.toString
}

object XChar {

  /**
    * 定义apply方法,创建对象
    *
    * @param char 实例化参数
    * @return 返回对象
    */
  def apply(char: Char) = new XChar(char)
}
