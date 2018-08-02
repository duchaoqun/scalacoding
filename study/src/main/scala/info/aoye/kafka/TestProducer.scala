package info.aoye.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord, RecordMetadata}

/**
  * 测试学习Producer
  */
object TestProducer extends scala.App {
  //创建Producer配置文件对象
  val props = new Properties()
  props.put("bootstrap.servers", "node1:6667")
  props.put("acks", "all")
  props.put("retries", "0")
  props.put("batch.size", "16384")
  props.put("linger.ms", "1")
  props.put("buffer.memory", "33554432")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  //创建一个Producer
  val producer = new KafkaProducer[String, String](props)

  //发送数据
  for (i <- 1 to 100) {
    producer.send(new ProducerRecord[String, String]("my-topic", i.toString, i.toString))
  }

  //关闭Producer,释放资源
  producer.close()
}
