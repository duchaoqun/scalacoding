package info.aoye.logging

import com.typesafe.scalalogging._
/**
  * 记录日志
  */
//TODO: scala.App need to study!
//https://github.com/lightbend/scala-logging
object TestLogging extends scala.App with LazyLogging {
  //TODO: logging level need to study!
  logger.info("asdf")
  logger.debug("asdfffff")
  logger.error("ddddd")
}



