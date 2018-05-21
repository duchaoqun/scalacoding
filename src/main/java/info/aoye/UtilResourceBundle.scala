package info.aoye

object UtilResourceBundle {

  def main(args: Array[String]): Unit = {
    val properties = new Properties()
    val path = Thread.currentThread().getContextClassLoader.getResource("jdbc.properties").getPath
    properties.load(new FileInputStream(path))
    println(properties.getProperty("abc","Null"))
    println(properties.getProperty("abd","Null"))
    val a = java.lang.System.getProperties
    println(a.getProperty("user.dir"))

    //TODO:获取上级文件路径，最有效的获取外部配置文件的方式？ 待学习
    val directory = new File("..")
    val filePath = directory.getAbsolutePath
  }
}
