package info.aoye.scala.TestEmail

object Demo {
  import info.aoye.scala.TestEmail._

  send a new Mail (
    from = ("john.smith@mycompany.com", "John Smith"),
    to = "boss@mycompany.com",
    cc = "hr@mycompany.com",
    subject = "Import stuff",
    message = "Dear Boss..."
  )

  send a new Mail (
    from = "john.smith@mycompany.com" -> "John Smith",
    to = Seq("dev@mycompany.com", "marketing@mycompany.com"),
    subject = "Our New Strategy (tm)",
    message = "Please find attach the latest strategy document.",
    richMessage = "Here's the <blink>latest</blink> <strong>Strategy</strong>..."
  )

  send a new Mail (
    from = "john.smith@mycompany.com" -> "John Smith",
    to = "dev@mycompany.com" :: "marketing@mycompany.com" :: Nil,
    subject = "Our 5-year plan",
    message = "Here is the presentation with the stuff we're going to for the next five years.",
    attachment = new java.io.File("/home/boss/important-presentation.ppt")
  )
}
