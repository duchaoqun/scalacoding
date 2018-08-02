package info.aoye.kafka

import java.util.Arrays
import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.TopicPartition

/**
  * 测试学习Consumer
  * 测试
  */
object TestConsumer extends scala.App {
  //创建配置文件对象
  val props = new Properties()
  props.put("bootstrap.servers", "node1:6667")
  props.put("group.id", "MyTest")
  props.put("enable.auto.commit", "true")   //是否自动确认offset
  props.put("auto.commit.interval.ms", "1000")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

  //创建一个Consumer对象
  val consumer = new KafkaConsumer[String, String](props)

  //消费者订阅的topic, 可同时订阅多个,这里需要使用java的Arrays
  //consumer.subscribe(Arrays.asList("my-topic"))



  //指派分区  设置topic 和 partition
  //1. 不会改变consumer group 的管理功能,不会改变当前消费组的offset值,这只是临时的. 也就是说这个没有加入到group中
  consumer.assign(Arrays.asList(new TopicPartition("my-topic", 0))) //从分区offset 0开始

  //consumer.seekToBeginning(Arrays.asList(new TopicPartition("my-topic", 0)))  //指定从这个分区的offset 0位置执行
  consumer.seek(new TopicPartition("my-topic", 0),10)  //从分区指定offset开始

  //获取数据部分内容
  while (true) {
    val records = consumer.poll(100)
    import scala.collection.JavaConversions._
    for (record <- records) {
      printf("offset = %d, key = %s, value = %s%n", record.offset, record.key, record.value)
    }
  }
}
