//package info.aoye.spark.streaming
//
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.Row
//import org.apache.spark.streaming.dstream.DStream
//import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.streaming.{Seconds, StreamingContext}
//
///**
//  * TODO：http://www.cnblogs.com/MOBIN/p/5348295.html
//  */
//object TestStreaming {
//  def main(args: Array[String]): Unit = {
//    // 创建配置信息
//    val conf = new SparkConf().setAppName("Test21").setMaster("spark://aoye:7077")
//    // 创建Spark容器
//    val sc = new SparkContext(conf)
//    // 在Spark容器里面创建Streaming，五秒钟一个Job
//    val ssc = new StreamingContext(sc, Seconds(5))
//
//    // 创建入口流，从socket进入, 注意是主机名 + 端口号
//    val lines = ssc.socketTextStream("aoye", 9999) //ReceiverInputDStream[String]
//    // 创建入口流，从文件进入? 是将多个文件拆分成tuple ？ 还是将一个文件流 每行拆分成tuple！？
//    //    val b = ssc.textFileStream("/home/aoye/Documents/tmpfiles/file1.txt").map(s => { ("", s) })
//    lines.foreachRDD((lines => {
//      ("", lines.toString())
//    }))
//
//    //TODO DStream就是一段Seconds内流入的数据集合，
//
//    //统计单词数量
//    val words = lines.flatMap(_.split(" "))
//    val pairs = words.map(word => (word, 1))
//    val wordCounts = pairs.reduceByKey(_ + _)
//
//    //打印内容
//    wordCounts.print()
//    lines.print()
//    ssc.start()
//    //等候（终端）终止（否则一直进行下去）
//    ssc.awaitTermination()
//
//    //TODO:队列的使用
//
//    //    val rddQueue = new scala.collection.mutable.Queue[RDD[Row]]
//    //
//    //    val queueStream = ssc.queueStream(rddQueue)
//    //    val test1 = queueStream.map(x => x.get(0))
//    //    test1.count().print()
//    //    rddQueue += table1.rdd
//
//    //优雅的方式结束Steaming，在流程处理完毕后再结束进程
//    ssc.stop(true, true)
//  }
//}
