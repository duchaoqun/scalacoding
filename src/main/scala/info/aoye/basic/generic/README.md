# scala 类型系统编程

scala的类,方法,函数都可以使用泛型, 在实际实例化的时候指定具体的类型
Spark源码中RDD里面关于RDD的类的定义是泛型的,RDD几乎所有的的方法定义都是泛型的, 
之所以这么做, 是因为RDD会派生很多子类, 通过子类适配各种不同的数据源以及业务逻辑操作.

用于指定类可以接受任意类型参数, 参数的类型在实际使用时才被确定, 泛型可以有效的增强程序的适应性, 使用泛型可以使得类或者方法具有更强的通用性.

# 对类型参数的界定:

## 上边界

下边界 对 类型的限定:必须为某种类型 或者某种类型的父类. 

例如: T 需要时 Person类或者Person的子类
```scala
class Club[T <: Person](p1:T,p2:T){
  def communicate():Unit = p1.talk(p2)
}
```

## 下边界

下边界 对 类型的限定:必须为某种类型 或者某种类型的父类.  >:

## 视图界定 View Bounds

对上下边界的补充加强版

```scala
  class Club[T <% Person](p1:T,p2:T){
    def communicate():Unit = p1.talk(p2)
  }
```

## 协变和逆变 Variance

对于泛型类C[+T]
现在有具体类型A 和 B ``````
如果B是A的子类,那么C[B]也是C[A]的子类,我们称这个类C支持协变,相反,C[-T]则称之为逆变

当我们定义一个协变类型List[+A]时，List[Child]可以是List[Parent]的子类型。
当我们定义一个逆变类型List[-A]时，List[Child]可以是List[Parent]的父类型。

## 参考文档

https://blog.csdn.net/zhanglh046/article/details/72845897
http://hongjiang.info/scala-pitfalls-10/
http://hongjiang.info/scala-covariance-and-contravariance/
https://blog.csdn.net/yuan_xw/article/details/49363749
