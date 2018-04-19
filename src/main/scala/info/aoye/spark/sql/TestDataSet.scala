package info.aoye.spark.sql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object TestDataSet {
  def main(args: Array[String]): Unit = {
    //创建Spark所依赖的环境内容
    val warehouse: String = "hdfs:/node2:8020/apps/hive/warehouse"

    //创建Spark配置信息对象
    val conf = new SparkConf()
      .setAppName("Test21")
      .setMaster("spark://aoye:7077")
      .set("spark.sql.warehouse.dir", warehouse)

    //Spark 1.0 创建Spark入口
    val sc = new SparkContext(conf)
    //Spark 2.0 创建Spark入口
    val ss = SparkSession.builder().config(conf).appName("TestSpark").master("Local[2]").enableHiveSupport().getOrCreate()

    //可以指定数据库,然后执行SQL获取数据.
    ss.sql("use gsdata")
    val df1 = ss.sql("select pripid,entname from e_baseinfo limit 66")
    //也可以直接在SQL里面直接指定数据库和表名.
    val df2 = ss.sql("select pripid,entname from gsdata.e_baseinfo limit 10")
    //抽样方法，获取20%的数据.
    val df3 = df1.sample(true,0.2)
  }
}
