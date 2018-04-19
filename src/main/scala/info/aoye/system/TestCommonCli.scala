package info.aoye.system

import org.apache.commons.cli._

//object TestCommonCli {
//  def main(args: Array[String]): Unit = {
//    // 创建命令行所需要的参数对象 -b  -u  -p
//    // java -jar aoye.jar -b 127.0.0.1:1080 -u duchaoqun -p 123456
//    val argsOptions = new Options().addOption("b", true, "local network interface ip address & port (ip:port) to which the server will listen for incoming connection requests (default 0.0.0.0:1080)")
//      .addOption("u", true, "authentication username (no auth if username & password are omitted)")
//      .addOption("p", true, "authentication password (no auth if username & password are omitted)")
//
//    // 创建解析对象
//    val argsParser = new DefaultParser
//
//    // 按照规则解析命令行参数
//    val cmdLine = argsParser.parse(argsOptions, args)
//
//    val address = cmdLine.getOptionValue("b").split(":")
//    val ip = address(0)
//    val port = address(1).toInt
//    val username = cmdLine.getOptionValue("u")
//    val password = cmdLine.getOptionValue("p")
//  }
//}
