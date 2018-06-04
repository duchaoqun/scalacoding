name := "Scala2.12.6"

version := "0.1"

scalaVersion := "2.12.6"


//定义组织名称
organization := "info.aoye"


// 引用Spark相关的包的版本号
val sparkVersion = "2.2.0"

// 配置不需要打包的内容？
//lazy val providedDependencies = Seq(
//  "org.apache.spark" %% "spark-core" % sparkVersion,
//  "org.apache.spark" %% "spark-sql" % sparkVersion,
//  "org.apache.spark" %% "spark-streaming" % sparkVersion
//)
// Change dependepcy scope to "provided" by : sbt -DprovidedDeps=true <task>
// 改变编译时提供的依赖引用范围，通过配置-DprovidedDeps=true 选项都编译进去，否则不编译进去
//val providedDeps = Option(System.getProperty("providedDeps")).getOrElse("false")
//
//providedDeps match {
//  case "true" => {
//    println("providedDeps = true")
//    libraryDependencies ++= providedDependencies.map(_ % "provided")
//  }
//  case "false" => {
//    println("providedDeps = false")
//    libraryDependencies ++= providedDependencies.map(_ % "compile")
//  }
//}

// 添加多个依赖包,
libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1",   //配置文件内容
  "com.typesafe.slick" %% "slick" % "3.2.3",            //jdbc持久层框架
  "org.slf4j" % "slf4j-nop" % "1.6.4",                   //jdbc持久层框架
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3",  //jdbc持久层框架
  "com.typesafe.slick" %% "slick-codegen" % "3.2.3"    //jdbc持久层框架
)

// 添加单个依赖包
// https://mvnrepository.com/artifact/org.antlr/antlr4-runtime
libraryDependencies += "org.antlr" % "antlr4-runtime" % "4.7"

// 日志处理部分包
// https://mvnrepository.com/artifact/com.typesafe.scala-logging/scala-logging
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.8.0"
// https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

// Scala操作Json的包
// https://mvnrepository.com/artifact/net.liftweb/lift-json
libraryDependencies += "net.liftweb" %% "lift-json" % "3.2.0"
// https://mvnrepository.com/artifact/com.typesafe.play/play-json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.9"

// MySQL驱动
// https://mvnrepository.com/artifact/mysql/mysql-connector-java
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.46"

// 命令行参数
// https://mvnrepository.com/artifact/commons-cli/commons-cli
libraryDependencies += "commons-cli" % "commons-cli" % "1.2"

// 网络编程
// https://mvnrepository.com/artifact/io.netty/netty-all
//libraryDependencies += "io.netty" % "netty-all" % "4.1.22.Final"
libraryDependencies += "io.netty" % "netty-all" % "4.0.43.Final"

//多线程
libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.8"
// https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.11"


libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.18.0"

// https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients  //Kafka包
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.10.2.1"

// https://mvnrepository.com/artifact/org.apache.hive/hive-jdbc
//libraryDependencies += "org.apache.hive" % "hive-jdbc" % "2.1.0"
//libraryDependencies += ("org.apache.hive" % "hive-jdbc" % "1.2.1")

// https://mvnrepository.com/artifact/javax.inject/javax.inject  依赖注入
libraryDependencies += "javax.inject" % "javax.inject" % "1"

// https://mvnrepository.com/artifact/org.jsoup/jsoup   解析HTML
libraryDependencies += "org.jsoup" % "jsoup" % "1.11.3"

// https://mvnrepository.com/artifact/org.apache.spark/spark-mllib  算法相关内容学习
//libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.3.0"
