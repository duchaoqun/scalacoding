package info.aoye.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object TestSpark {
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

    // 创建RDD对象
    val rdd1 = sc.makeRDD(List(1, 2, 3, 4, 5))
    val rdd2 = sc.makeRDD(Array("a", "b", "c", "d", "e"))
    val rdd3 = sc.parallelize(List(1, 2, 3, 4, 5), 1)
    val rdd4 = sc.textFile("file:///opt/sparkdata.txt") //TODO：尚未测试
    val rdd5 = sc.makeRDD("asdf") //TODO:尚未测试，不知道字符串是否可以

    //RDD相关的隐式转换引用
    import ss.implicits._ //其中ss 是上面定义的SparkSession
    //创建一个json对象
    val name = "duchaoqun"
    val age = 12
    val rdd6 = ss.sparkContext.makeRDD(s"""{name:${name},age:${age}""")
    val str1 = s"""{name:${name},age:${age}"""
    //TODO： Seq对象可以转换成DS？ 这里需要再学学
    val rdd7 = ss.read.json(Seq(str1).toDS)

    //老版本的写法
    //    val jsonStr = """{ "metadata": { "key": 84896, "value": 54 }}"""
    //    val rdd = sc.parallelize(Seq(jsonStr))
    //    val df = sqlContext.read.json(rdd)
  }

}
