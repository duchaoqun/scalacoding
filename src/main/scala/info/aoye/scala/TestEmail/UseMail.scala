package info.aoye.scala.TestEmail

/**
  * 发送邮件的案例
  */
object UseMail extends scala.App {

  //直接调用包对象,传递一个Mail类型对象.
  send a Mail (
    from = ("du.chao.qun@163.com", "duchaoqun"),
    to = "848408012@qq.com",
    cc = "duchaoqun@rexen.com.cn",
    subject = "TestMail",
    message = "Dear..."
  )

//  send a new Mail (
//    from = "du.chao.qun@163.com" -> "duchaoqun",
//    to = Seq("848408012@qq.com", "848408012@qq.com"),
//    subject = "TestMailOne",
//    message = "Dear!!!",
//    richMessage = "Here's the <blink>latest</blink> <strong>Strategy</strong>..."
//  )
//
//  send a new Mail (
//    from = "du.chao.qun@163.com" -> "duchaoqun",
//    to = "848408012@qq.com" :: "848408012@qq.com" :: Nil,
//    subject = "TestMailTwo",
//    message = "Test ppt files",
//    attachment = new java.io.File("/home/boss/important-presentation.ppt")
//  )
}
