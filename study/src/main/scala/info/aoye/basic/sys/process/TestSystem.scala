package info.aoye.basic.sys.process

import java.io.File
import java.net.URL

// 首先需要导入这个包
import scala.sys.process._

/**
  * 执行系统命令
  * 1. 在执行系统命令的代码行后面需要空一个空行，不知道为什么
  * 2. 工作原理: Scala是基于JVM进程的, Scala程序运行的时候会运行在JVM进程中, 而JVM是OS的一个普通进程, 通过JVM可以直接和
  *    OS进行交互, 而OS中有例如启动进程等功能, 所以!!!
  */
object TestSystem extends scala.App {
  //执行系统命令，等待该命令执行完毕后返回结果，然后在继续执行下面的代码
  //注意：可以在sh里面加时间控制
  //http://www.scala-lang.org/api/2.12.2/scala/sys/process/index.html

  //执行外部命令
  val int1 = "/home/aoye/Documents/bash/test.sh".!
  println(int1)

  //直接打印命令结果
  val int2 = "ls".!
  println(int2) //命令成功执行返回0，不等于0说明命令执行出错

  //将命令执行结果保存到变量中
  val str1 = "ls".!!
  println(str1.getClass) //java.lang.String
  println(str1)

  //逻辑操作管道  #|   与操作 #&&  或操作#||
  //"find src -name *.scala -exec grep null {} ;" #| "xargs test -z" #&& "echo null-free" #|| "echo null detected" !


  //重定向#< 和 #>
  //scala的重定向不仅可以从定向普通的文件，还可以把网络上的文件进行重定向到本地:
  //注意：url和file均需进行封装 java.net.URL 否则会出现报错
  //将网络地址内容重定向到本地
  new URL("http://aoye.info") #> new java.io.File("/tmp/a.html") !

  //命令结果重定向到文件
  "ls -l" #> new File("/tmp/ls.txt") !!

  //将文件内容重定向给指定命令
  "cat" #< new File("/tmp/ls.txt") !

  //将文件重定向到新文件
  new File("/tmp/ls.txt") #> new File("/tmp/lsnew.txt") !!


  //追加操作  #>>  #<<
  //a #>> file or file #<<  与重定向类似


  //    与cat一起使用
  //    val spde = new URL("http://technically.us/spde/About")
  //    val dispatch = new URL("http://databinder.net/dispatch/About")
  //    val build = new File("project/build.properties")
  //    cat(spde, dispatch, build) #| "grep -i scala" !

  //获取操作系统环境变量
  //println(System.getenv("PATH"))
}
