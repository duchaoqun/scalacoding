package info.aoye.basic.TestAnnotation

/**
  * Annotation是一种对程序代码进行描述的结构化信息.
  * Annotation可以分布在程序的任何地方,能够注解变量,类,方法,参数等多种元素.
  * Scala中的注解语法与Java中类似,标准库定义的注解相关内容在包scala.annotation中.
  * Annotation基本语法 @注解名称(注解参数...) 注解参数不是必须的,一个元素允许拥有多个注解.
  *
  * Scala 2.10之前,Scala并未提供自定义注解功能,自定义注解需要在Java源码中进行.
  * Scala 2.10开始,作为Reflect功能的一部分,Scala提供了自定义注解支持.
  * 与反射相关功能类似，到目前版本(Scala 2.12)为止，注解相关功能依然是Expermental(实验性)的
  *
  * 使用场景
  * 1. 自动生成scala文档
  * 2. 检查程序中可能出现的语法问题
  * 3. 规定程序行为
  */
object TestAnnotation extends scala.App {

}
