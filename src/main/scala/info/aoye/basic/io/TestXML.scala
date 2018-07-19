package info.aoye.basic.io

/**
  * xml:Elem 默认的XML解析框架?? scala.xml._
  */
object TestXML extends scala.App {
  val xml = <html><head><title>Hi</title></head><body>Hello</body></html>
  println(xml.label)
  println(xml.child)
}
