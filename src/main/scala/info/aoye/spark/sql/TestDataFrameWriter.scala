package info.aoye.spark.sql

import org.apache.spark.sql.{DataFrame, DataFrameWriter, Dataset, SparkSession}


object TestDataFrameWriter {
  //创建SparkSession对象
  val sc = SparkSession.builder().enableHiveSupport().getOrCreate()

  //创建隐式操作对象,否则不能使用toDF方法.
  import sc.implicits._
  val dataFrame1:DataFrame = Seq((1,2),(3,4)).toDF()  //创建DataFrame对象,无列标题
  val dataFrame2:DataFrame = Seq((5,6),(7,8)).toDF("col1","col2") //创建DataFrame对象,有列标题
  //1. DateSet and DataFrame has write method , it return a DataFrameWriter object !
  //2. 设置写入类型,overwrite 覆盖已有数据,append 追加数据,ignore,error 默认.
  //3. insertInto是基于位置进行插入数据,与列标题无关. 但是列数必须与存在的表列数一致
  dataFrame1.write.mode("overwrite").insertInto("table1") //插入到已有的数据表,覆盖数据
  dataFrame1.write.mode("append").insertInto("table1") //插入到已有的数据表,追加数据
  dataFrame1.write.mode("append").insertInto("table1") //插入到已有的数据表,追加数据

  //1. 使用overwrite参数,覆盖已经存在的表和数据
  //2. 使用append参数,插入数据,注意列名称需要一致,顺序可以不一致.
  //3. 使用append参数,创建表,如果目标表不存在,这里会创建表.
  Seq((5,6)).toDF("col1","col2").write.mode("overwrite").saveAsTable("table2")
  Seq((7,8)).toDF("col1","col2").write.mode("append").saveAsTable("table2") //插入数据,列位置相同
  Seq((7,8)).toDF("col2","col1").write.mode("append").saveAsTable("table2") //插入数据,列位置不同

}
