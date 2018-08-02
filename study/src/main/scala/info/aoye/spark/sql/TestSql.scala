//package info.aoye.spark.sql
//
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.{Row, SparkSession}
//import org.apache.spark.streaming.{Seconds, StreamingContext}
//import org.apache.spark.{SparkConf, SparkContext}
//
//
//object TestSql {
//  def main(args: Array[String]): Unit = {
//    //创建Spark所依赖的环境内容
//    val warehouse: String = "hdfs:/node2:8020/apps/hive/warehouse"
//
//    //创建Spark配置信息对象
//    val conf = new SparkConf()
//      .setAppName("Test21")
//      .setMaster("yarn")
//      .set("spark.sql.warehouse.dir",warehouse)
//
//    //1.0 版本入口 创建Spark入口
//    val sc = new SparkContext(conf)
//
//    //2.0 版本入口，创建SparkSession入口[根据需要修改，设置支持Hive]
//    val ss1 = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
//    val ss2 = SparkSession.builder().appName("ss2").master("local[2]").enableHiveSupport().getOrCreate()
//    //也可以从其他对象里面获取配置
//    val ss3 = SparkSession.builder().config(sc.getConf.set("spark.sql.warehouse.dir", warehouse)).enableHiveSupport().getOrCreate()
//
//    //执行SQL语句
//    ss1.sql("use gsdata")
//    //在Spark容器里面创建Streaming，五秒钟一个Job
//    val ssc = new StreamingContext(sc, Seconds(5))
//
//    //Get hive table data with SQL!
//    val table1 = ss1.sql("select pripid,entname,enttype from e_baseinfo limit 5")
//
//    //重新命名DataFrame的列名
//    val renameTableColumns = table1.toDF("column1", "column2", "column3")
//
//    //在本Session中创建临时表，可以提供后续查询使用，例如直接插入Hive库中
//    //TODO: 这里还需要详细学习一下
//    renameTableColumns.createOrReplaceGlobalTempView("tmp1")
//    ss1.sql("create table as select column1,column2,column3 from tmp1")
//
//    println(table1.first())
//
//  }
//}
