package info.aoye.basic.generic

class Person

class Student extends Person

class C[+T](val args: T) //泛型类

class S[+T](arg: T) extends C[T](arg) //对于子类，同样要支持协变或者逆变

trait Friend[-T] {
  def makeFriend(somebody: T)
}

object Variance {
  def makeFriendWithYou(s: Student, f: Friend[Student]) {
    f.makeFriend(s)
  }

  def main(args: Array[String]) {
    val value: C[Person] = new C[Student](new Student) // List list = new ArrayList()
    val list: List[_ <: Any] = List[String]("Spark")
  }
}
