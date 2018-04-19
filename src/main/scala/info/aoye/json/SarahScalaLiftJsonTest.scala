package info.aoye.json

import net.liftweb.json.DefaultFormats
import net.liftweb.json._

/**
  * 1. Scala使用Json
  * 2. Lift -JSON 包的使用
  */
object SarahScalaLiftJsonTest {

  implicit val formats = DefaultFormats

  val mailAccountString =
    """
  {
    "accounts": [
    { "emailAccount": {
      "accountName": "YMail",
      "username": "USERNAME",
      "password": "PASSWORD",
      "url": "imap.yahoo.com",
      "minutesBetweenChecks": 1,
      "usersOfInterest": ["barney", "betty", "wilma"]
    }},
    { "emailAccount": {
      "accountName": "Gmail",
      "username": "USER",
      "password": "PASS",
      "url": "imap.gmail.com",
      "minutesBetweenChecks": 1,
      "usersOfInterest": ["pebbles", "bam-bam"]
    }}
    ]
  }
  """

  def main(args: Array[String]) {
    //包类型,解析json字符串
    val json = parse(mailAccountString)

    //json的方法\\ 获取对象属性,这个方法定义的有些意思
    val elements = (json \\ "emailAccount").children

    //遍历打印
    for (acct <- elements) {
      //todo:this need to study!
      val m = acct.extract[EmailAccount]
      println(m.url)
      println(m.username)
      println(m.password)
      m.usersOfInterest.foreach(println)
    }
  }

}

/**
  * A case class to match the json properties(property).
  * 创建一个case class 匹配json的属性.
  */
case class EmailAccount(
                         accountName: String,
                         url: String,
                         username: String,
                         password: String,
                         minutesBetweenChecks: Int,
                         usersOfInterest: List[String]
                       )