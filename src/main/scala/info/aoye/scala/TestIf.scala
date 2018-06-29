package info.aoye.scala

/**
  * scala if 表达式 expression
  */
object TestIf extends scala.App {
  // 1. 特征: scala中的if条件表达式是有值的.可以把他的值赋给一个对象.
  // 2. 特征: if表达式可以进行类型推导,一般过程就是依据变量的类型进行推导,(可以省略类型的书写).
  // 3. 特征: 如果if表达式没有else部分,结果类型就变成Any类型,不建议这么写.
  var age = 10
  var result1 = if (age > 25) "Worker" else "Student" // result的类型是String类型,因为两个分支都是String类型.
  var result2 = if (age > 18) "Adult" else 1 // result2的类型是Any,因为两个分支一个是String,一个Int,所以类型是两者的公共类型Any.
  var result3 = if (age > 18) "Adult" // result2的类型是Any, 因为表达式省略了" else ()",两个分支分别是String类型和Unit类型. () 代表Unit类型,不建议这么写.
  //println(result3) // ()

  // 案例: Option类型是处理业务逻辑需要的类型,一般使用如下写法.
  val isEventLogEnabled = true
  if (isEventLogEnabled) {
    Some("Log")
  } else {
    None
  }

  // if表达式可以用在for循环等其他控制结构中.
  for (i <- 0 to 10 if i%2 == 0) {
    println(i)
  }
}
