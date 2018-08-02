package info.aoye.util

object TestUUID extends scala.App {
  //生成通用唯一识别码(UUID)
  val uuid = java.util.UUID.randomUUID()

  println(uuid)
  println(uuid.getClass)
  //替换掉字符串中的 - 字符
  println(uuid.toString.replace("-","").toLowerCase())
}
