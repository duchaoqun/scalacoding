package info.aoye.json

import play.api.libs.json._

case class Location(lat: Double, long: Double)

case class Resident(name: String, age: Int, role: Option[String])

case class Place(name: String, location: Location, residents: Seq[Resident])

/**
  * Scala借助libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.9" 包 操作json对象.
  * 1. 用字符串创建JsValue, 使用Js相关的对象创建JsValue, 基本类型转换JsValue
  * 2. Object 转换成 JsValue
  * 3. JsValue 转换成 Object
  * 4. JsValue 转换成 字符串,获取jsonStr
  */
object TestJsonOne extends scala.App {

  //1. 使用字符串创建一个JsValue对象.
  val json1: JsValue = Json.parse(
    """
      {
        "name" : "Watership Down",
        "location" : {
          "lat" : 51.235685,
          "long" : -1.309197
        },
        "residents" : [ {
          "name" : "Fiver",
          "age" : 4,
          "role" : null
        }, {
          "name" : "Bigwig",
          "age" : 6,
          "role" : "Owsla"
        } ]
      }
      """
  )

  //1. 使用Js相关的对象创建JsValue,其实可以不使用JsArray这样的对象,直接使用字符即可(官方已经对基本类型做了隐式转换).
  val json2: JsValue = JsObject(Seq(
    "name" -> JsString("Watership Down"),
    "location" -> JsObject(Seq("lat" -> JsNumber(51.235685), "long" -> JsNumber(-1.309197))),
    "residents" -> JsArray(IndexedSeq(
      JsObject(Seq(
        "name" -> JsString("Fiver"),
        "age" -> JsNumber(4),
        "role" -> JsNull
      )),
      JsObject(Seq(
        "name" -> JsString("Bigwig"),
        "age" -> JsNumber(6),
        "role" -> JsString("Owsla")
      ))
    ))
  ))

  //1. 使用隐式转换
  val json3: JsValue = Json.obj(
    "name" -> "Watership Down",
    "location" -> Json.obj("lat" -> 51.235685, "long" -> -1.309197),
    "residents" -> Json.arr(
      Json.obj(
        "name" -> "Fiver",
        "age" -> 4,
        "role" -> JsNull
      ),
      Json.obj(
        "name" -> "Bigwig",
        "age" -> 6,
        "role" -> "Owsla"
      )
    )
  )

  //1. 基本类型转换JsValue,这里调用的是隐式转换的方法实现的.
  val jsonString = Json.toJson("Fiver")
  val jsonNumber = Json.toJson(4)
  val jsonBoolean = Json.toJson(false)
  val jsonArrayOfInts = Json.toJson(Seq(1, 2, 3, 4))
  val jsonArrayOfStrings = Json.toJson(List("Fiver", "Bigwig"))


  //2. 将对象转换成Json,这里需要自定义隐式转换的方法,然后就可以自由调用toJson, 来将对象直接转换成json了.
  implicit val locationWrites: Writes[Location] = new Writes[Location] {
    def writes(location: Location): JsObject = Json.obj(
      "lat" -> location.lat,
      "long" -> location.long
    )
  }

  implicit val residentWrites: Writes[Resident] = new Writes[Resident] {
    def writes(resident: Resident): JsObject = Json.obj(
      "name" -> resident.name,
      "age" -> resident.age,
      "role" -> resident.role
    )
  }

  implicit val placeWrites: Writes[Place] = new Writes[Place] {
    def writes(place: Place): JsObject = Json.obj(
      "name" -> place.name,
      "location" -> place.location,
      "residents" -> place.residents
    )
  }

  val place = Place(
    "Watership Down",
    Location(51.235685, -1.309197),
    Seq(
      Resident("Fiver", 4, None),
      Resident("Bigwig", 6, Some("Owsla"))
    )
  )

  //2. 定义完隐式转换了,这里就直接调用他的接口了.
  val json4: JsValue = Json.toJson(place)
  println(json4) //{"name":"Watership Down","location":{"lat":51.235685,"long":-1.309197},"residents":[{"name":"Fiver","age":4,"role":null},{"name":"Bigwig","age":6,"role":"Owsla"}]}

  //3. JsValue转换成对象,必须隐式定义Read[T] 中的T为你需要的类型.
  import play.api.libs.functional.syntax._

  implicit val locationReads: Reads[Location] = (//定义隐式转换,
    (JsPath \ "lat").read[Double] and
      (JsPath \ "long").read[Double]
    ) (Location.apply _)

  implicit val residentReads: Reads[Resident] = (//定义隐式转换,
    (JsPath \ "name").read[String] and
      (JsPath \ "age").read[Int] and
      (JsPath \ "role").readNullable[String]
    ) (Resident.apply _)

  implicit val placeReads: Reads[Place] = (//定义隐式转换,
    (JsPath \ "name").read[String] and
      (JsPath \ "location").read[Location] and
      (JsPath \ "residents").read[Seq[Resident]]
    ) (Place.apply _)

  //3. JsValue转换成对象
  val placeResult: JsResult[Place] = json4.validate[Place]
  // JsSuccess(Place(...),)

  val residentResult: JsResult[Resident] = (json4 \ "residents") (1).validate[Resident]
  // JsSuccess(Resident(Bigwig,6,Some(Owsla)),)

  //3. 获取对象
  placeResult.get
  residentResult.get


  //遍历JsValue结构:直接查询,如果内容不存在就会抛出错误.
  println(json4.apply("name")) //"Watership Down"
  println(json4("name")) //"Watership Down"
  println(json4("residents")(1)) //{"name":"Bigwig","age":6,"role":"Owsla"}

  //遍历JsValue结构:使用单一路径进行访问,让JsValue返回一个JsObject或者JsArray的索引,如果引用错误,或者不存在,会抛出异常.
  val lat = (json4 \ "location" \ "lat").get //51.235685
  val bigwig = (json4 \ "residents" \ 1).get //{"name":"Bigwig","age":6,"role":"Owsla"}

  //遍历JsValue结构:递归查找,会返回所有对应的value值,包括当前路径和子集路径. 注意返回值是List对象
  val names_1 = json4 \\ "name" //List("Watership Down", "Fiver", "Bigwig")

  //遍历JsValue结构:将JsValue转换成一个字符串
  val minifiedString: String = Json.stringify(json4) //直接打印一个字符串
  val readableString: String = Json.prettyPrint(json4) //格式化过的字符串

  {
    //将JsValue转换成指定类型值
    //默认Writes类提供基础的类型转换,其他类型我们需要自定义隐式转换函数.
    //as方法如果没有获取对应的内容会抛出异常,留意asOpt方法(尽管他是安全的,但是错误信息全丢了.)
    val name = (json4 \ "name").as[String] //这里name字段的值需要是String类型,然后我们获取这个String,再转换成我们需要的其他类型.
    // "Watership Down"

    val names_2 = (json4 \\ "name").map(_.as[String]) //对象隐式类型转换
    // Seq("Watership Down", "Fiver", "Bigwig")

    val nameOption = (json4 \ "name").asOpt[String] //存在值
    // Some("Watership Down")

    val bogusOption = (json4 \ "bogus").asOpt[String] //不存在值
    // None

    val jsValue1 = Json.parse("""{"status":"1","count":"1","info":"OK","infocode":"10000","lives":[[]]}""")
    val count = (jsValue1 \ "count").get.as[String].toInt
  }
  //转换的时候使用验证
  val nameResult: JsResult[String] = (json4 \ "name").validate[String]

  // 分区匹配
  nameResult match {
    case s: JsSuccess[String] => println("Name: " + s.get)
    case e: JsError => println("Errors: " + JsError.toJson(e).toString())
  }

  // 存在值,或者不存在值
  val nameOrFallback = nameResult.getOrElse("Undefined")

  // 操作
  val nameUpperResult: JsResult[String] = nameResult.map(_.toUpperCase())

  // fold
  val nameOption1: Option[String] = nameResult.fold(
    invalid = {
      fieldErrors =>
        fieldErrors.foreach(x => {
          println("field: " + x._1 + ", errors: " + x._2)
        })
        None
    },
    valid = {
      name => Some(name)
    }
  )


}
