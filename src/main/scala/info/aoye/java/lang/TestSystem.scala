package info.aoye.java.lang

import java.lang.System

object TestSystem extends scala.App {
  //设置全局的系统属性,可以在程序的任何地方使用的键值对.
  System.setProperty("ddd","111")
}
