偏应用函数

偏应用函数(Partial Applied Function)也叫部分应用函数，跟偏函数(Partial Function)从英文名来看只有一字之差，但他们二者之间却有天壤之别。
部分应用函数, 是指一个函数有n个参数, 而我们为其提供少于n个参数, 那就得到了一个部分应用函数。
个人理解的偏应用函数类似于柯里化

举个例子，定义好一个函数有3个参数，再提供几个有1-2个已知参数的偏应用函数

scala> def add(x:Int,y:Int,z:Int) = x+y+z
add: (x: Int, y: Int, z: Int)Int

scala> def addX = add(1,_:Int,_:Int) // x 已知
addX: (Int, Int) => Int

scala> addX(2,3)
res1: Int = 6

scala> addX(3,4)
res2: Int = 8

scala> def addXAndY = add(10,100,_:Int) // x 和 y 已知
addXAndY: Int => Int

scala> addXAndY(1)
res3: Int = 111

scala> def addZ = add(_:Int,_:Int,10) // z 已知
addZ: (Int, Int) => Int

scala> addZ(1,2)
res4: Int = 13