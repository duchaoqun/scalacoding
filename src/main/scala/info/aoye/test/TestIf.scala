package info.aoye.test

class TestIf {
  def testIf() = {
    val x: Int = 123
    // 第一种用法
    if (x > 1) x else 1

    // 第二种用法,if表达式也可以直接作为返回值
    val a: Int = if (x < 1) x else 1

    // 第三种用法,混合类型返回值,两个分支返回两种不同的类型
    val b = if (x < 1) "ABC" else 1

    // 注意：如下两种写法是一样的,() means Unit object
    if (x < 1) x
    if (x < 1) x else ()

    // 注意,最常见的写作格式,使用花括号分行
    if (x <1){
      x
    } else{
      "123"
    }

    // 块表达式：使用花括号括起来的一段代码，其作为一个整体来看。
    // 块表达式中最后一个表达式的值就是 块结果值。
    {
      val a = 123
      val b = 456
      a + b //这个返回块表达式的值
    }

  }

}
