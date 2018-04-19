package info.aoye.java.util

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}
import com.github.nscala_time.time._

/**
  * 使用Scala处理时间串
  */
object TestDate extends scala.App {


  //返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。
  val time1 = System.currentTimeMillis()  //单位ms 1522376351710
  val time2 = System.nanoTime()  //单位ns 14211563480827

  println(time1)
  println(time2)

  /**
    * 获取操作系统当前时间
    * @return yyyy-MM-dd HH:mm:ss
    */
  def getCurrentSystemTime():String = {
    val now = System.currentTimeMillis()
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val dateNow = new Date(now)
    format.format(dateNow)
  }

  /**
    * 获取操作系统当前时间
    * @return yyyy-MM-dd HH:mm:ss
    */
  def getCurrentTime(): String = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))

  // 2018
  def getCurrentYear(): String = (new SimpleDateFormat("yyyy").format(new Date()))

  // 03
  def getCurrentMonth(): String = (new SimpleDateFormat("MM").format(new Date()))

  // 1522301870
  def getCurrentTimeUnix(): Long = (new Date().getTime.toString().substring(0, 10).toLong)

  // 2018-03-29 00:00:00
  def getZeroTime(): String = (new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 00:00:00")

  // 1522302000
  //def getZeroTimeUnix():Long=((new Date().getTime.toString().substring(0,8)+"00").toLong)
  def getZeroTimeUnix(): Long = {
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val a = dateFormat.parse(dateFormat.format(new Date())).getTime
    var str = a + ""
    str.substring(0, 10).toLong
  }

  def addTime(date: String, num: Int): String = {
    val myformat = new SimpleDateFormat("yyyyMMddHH")
    var dnow = new Date()
    if (date != "") {
      dnow = myformat.parse(date)
    }
    var cal = Calendar.getInstance()
    cal.setTime(dnow)
    cal.add(Calendar.DAY_OF_MONTH, num)
    val newday = cal.getTime()
    myformat.format(newday)
  }

  /**
    * 接收两个时间字符串，然后计算时间差
    * @param timeA yyyy-MM-dd HH:mm:ss
    * @param timeB yyyy-MM-dd HH:mm:ss
    * @return 0天0小时0分钟36秒
    */
  def timeBetween(timeA: String, timeB: String): String = {
    val df: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val timeBegin: Date = df.parse("2018-03-30 13:30:24")
    val timeEnd: Date = df.parse("2018-03-30 13:31:00")
    val between: Long = (timeEnd.getTime() - timeBegin.getTime()) / 1000 //除以1000是为了转换成秒
    val day: Long = between / (24 * 3600)
    val hour: Long = between % (24 * 3600) / 3600
    val minute: Long = between % 3600 / 60
    val second: Long = between % 60
    day + "天" + hour + "小时" + minute + "分钟" + second + "秒"
  }
}
