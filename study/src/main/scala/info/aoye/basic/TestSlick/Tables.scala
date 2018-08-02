package info.aoye.basic.TestSlick

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(ClusterServer.schema, GaodeWeatherinfo.schema, Person.schema, PluginCategory.schema, PluginMain.schema, Region.schema, ResourceCategory.schema, ResourceDb.schema, ResourceDbConnPool.schema, ResourceDbParam.schema, ResourceMain.schema, ResourceQuery.schema, ResourceQueryParam.schema, ResourceQueryReference.schema, ResourceTable.schema, ResourceTableColumn.schema, ServiceAuthorization.schema, ServiceCategory.schema, ServiceMain.schema, ServiceVersion.schema, SystemDepartment.schema, SystemOperationLog.schema, SystemOperationParam.schema, SystemUser.schema, Testtable.schema, User.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table ClusterServer
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param name Database column name SqlType(VARCHAR), Length(50,true)
   *  @param host Database column host SqlType(VARCHAR), Length(20,true)
   *  @param port Database column port SqlType(INT), Default(80)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ClusterServerRow(id: String, name: String, host: String, port: Int = 80, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ClusterServerRow objects using plain SQL queries */
  implicit def GetResultClusterServerRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[ClusterServerRow] = GR{
    prs => import prs._
    ClusterServerRow.tupled((<<[String], <<[String], <<[String], <<[Int], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table cluster_server. Objects of this class serve as prototypes for rows in queries. */
  class ClusterServer(_tableTag: Tag) extends profile.api.Table[ClusterServerRow](_tableTag, Some("aoye"), "cluster_server") {
    def * = (id, name, host, port, description, lastModificationTime) <> (ClusterServerRow.tupled, ClusterServerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(host), Rep.Some(port), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ClusterServerRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("name", O.Length(50,varying=true))
    /** Database column host SqlType(VARCHAR), Length(20,true) */
    val host: Rep[String] = column[String]("host", O.Length(20,varying=true))
    /** Database column port SqlType(INT), Default(80) */
    val port: Rep[Int] = column[Int]("port", O.Default(80))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")
  }
  /** Collection-like TableQuery object for table ClusterServer */
  lazy val ClusterServer = new TableQuery(tag => new ClusterServer(tag))

  /** Entity class storing rows of table GaodeWeatherinfo
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param province Database column province SqlType(CHAR), Length(20,false), Default(None)
   *  @param city Database column city SqlType(CHAR), Length(20,false), Default(None)
   *  @param adcode Database column adcode SqlType(CHAR), Length(10,false), Default(None)
   *  @param weather Database column weather SqlType(CHAR), Length(20,false), Default(None)
   *  @param temperature Database column temperature SqlType(CHAR), Length(10,false), Default(None)
   *  @param winddirection Database column winddirection SqlType(CHAR), Length(10,false), Default(None)
   *  @param windpower Database column windpower SqlType(CHAR), Length(5,false), Default(None)
   *  @param humidity Database column humidity SqlType(CHAR), Length(5,false), Default(None)
   *  @param reporttime Database column reporttime SqlType(CHAR), Length(20,false), Default(None) */
  case class GaodeWeatherinfoRow(id: Int, province: Option[String] = None, city: Option[String] = None, adcode: Option[String] = None, weather: Option[String] = None, temperature: Option[String] = None, winddirection: Option[String] = None, windpower: Option[String] = None, humidity: Option[String] = None, reporttime: Option[String] = None)
  /** GetResult implicit for fetching GaodeWeatherinfoRow objects using plain SQL queries */
  implicit def GetResultGaodeWeatherinfoRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[GaodeWeatherinfoRow] = GR{
    prs => import prs._
    GaodeWeatherinfoRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table gaode_weatherinfo. Objects of this class serve as prototypes for rows in queries. */
  class GaodeWeatherinfo(_tableTag: Tag) extends profile.api.Table[GaodeWeatherinfoRow](_tableTag, Some("aoye"), "gaode_weatherinfo") {
    def * = (id, province, city, adcode, weather, temperature, winddirection, windpower, humidity, reporttime) <> (GaodeWeatherinfoRow.tupled, GaodeWeatherinfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), province, city, adcode, weather, temperature, winddirection, windpower, humidity, reporttime).shaped.<>({r=>import r._; _1.map(_=> GaodeWeatherinfoRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column province SqlType(CHAR), Length(20,false), Default(None) */
    val province: Rep[Option[String]] = column[Option[String]]("province", O.Length(20,varying=false), O.Default(None))
    /** Database column city SqlType(CHAR), Length(20,false), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Length(20,varying=false), O.Default(None))
    /** Database column adcode SqlType(CHAR), Length(10,false), Default(None) */
    val adcode: Rep[Option[String]] = column[Option[String]]("adcode", O.Length(10,varying=false), O.Default(None))
    /** Database column weather SqlType(CHAR), Length(20,false), Default(None) */
    val weather: Rep[Option[String]] = column[Option[String]]("weather", O.Length(20,varying=false), O.Default(None))
    /** Database column temperature SqlType(CHAR), Length(10,false), Default(None) */
    val temperature: Rep[Option[String]] = column[Option[String]]("temperature", O.Length(10,varying=false), O.Default(None))
    /** Database column winddirection SqlType(CHAR), Length(10,false), Default(None) */
    val winddirection: Rep[Option[String]] = column[Option[String]]("winddirection", O.Length(10,varying=false), O.Default(None))
    /** Database column windpower SqlType(CHAR), Length(5,false), Default(None) */
    val windpower: Rep[Option[String]] = column[Option[String]]("windpower", O.Length(5,varying=false), O.Default(None))
    /** Database column humidity SqlType(CHAR), Length(5,false), Default(None) */
    val humidity: Rep[Option[String]] = column[Option[String]]("humidity", O.Length(5,varying=false), O.Default(None))
    /** Database column reporttime SqlType(CHAR), Length(20,false), Default(None) */
    val reporttime: Rep[Option[String]] = column[Option[String]]("reporttime", O.Length(20,varying=false), O.Default(None))
  }
  /** Collection-like TableQuery object for table GaodeWeatherinfo 集合一样的表信息*/
  lazy val GaodeWeatherinfo = new TableQuery(tag => new GaodeWeatherinfo(tag))

  /** Entity class storing rows of table Person
   *  @param id Database column id SqlType(INT), Default(None)
   *  @param name Database column name SqlType(CHAR), Length(20,false), Default(None)
   *  @param certid Database column certid SqlType(CHAR), Length(20,false), Default(None)
   *  @param certype Database column certype SqlType(INT), Default(None)
   *  @param certypeCn Database column certype_cn SqlType(CHAR), Length(20,false), Default(None)
   *  @param sex Database column sex SqlType(CHAR), Length(4,false), Default(None)
   *  @param insertTime Database column insert_time SqlType(TIMESTAMP) */
  case class PersonRow(id: Option[Int] = None, name: Option[String] = None, certid: Option[String] = None, certype: Option[Int] = None, certypeCn: Option[String] = None, sex: Option[String] = None, insertTime: java.sql.Timestamp)
  /** GetResult implicit for fetching PersonRow objects using plain SQL queries */
  implicit def GetResultPersonRow(implicit e0: GR[Option[Int]], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[PersonRow] = GR{
    prs => import prs._
    PersonRow.tupled((<<?[Int], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table person. Objects of this class serve as prototypes for rows in queries. */
  class Person(_tableTag: Tag) extends profile.api.Table[PersonRow](_tableTag, Some("aoye"), "person") {
    def * = (id, name, certid, certype, certypeCn, sex, insertTime) <> (PersonRow.tupled, PersonRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id, name, certid, certype, certypeCn, sex, Rep.Some(insertTime)).shaped.<>({r=>import r._; _7.map(_=> PersonRow.tupled((_1, _2, _3, _4, _5, _6, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), Default(None) */
    val id: Rep[Option[Int]] = column[Option[Int]]("id", O.Default(None))
    /** Database column name SqlType(CHAR), Length(20,false), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(20,varying=false), O.Default(None))
    /** Database column certid SqlType(CHAR), Length(20,false), Default(None) */
    val certid: Rep[Option[String]] = column[Option[String]]("certid", O.Length(20,varying=false), O.Default(None))
    /** Database column certype SqlType(INT), Default(None) */
    val certype: Rep[Option[Int]] = column[Option[Int]]("certype", O.Default(None))
    /** Database column certype_cn SqlType(CHAR), Length(20,false), Default(None) */
    val certypeCn: Rep[Option[String]] = column[Option[String]]("certype_cn", O.Length(20,varying=false), O.Default(None))
    /** Database column sex SqlType(CHAR), Length(4,false), Default(None) */
    val sex: Rep[Option[String]] = column[Option[String]]("sex", O.Length(4,varying=false), O.Default(None))
    /** Database column insert_time SqlType(TIMESTAMP) */
    val insertTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("insert_time")
  }
  /** Collection-like TableQuery object for table Person */
  lazy val Person = new TableQuery(tag => new Person(tag))

  /** Entity class storing rows of table PluginCategory
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param name Database column name SqlType(VARCHAR), Length(20,true)
   *  @param catkey Database column catkey SqlType(VARCHAR), Length(100,true)
   *  @param sortNo Database column sort_no SqlType(INT)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class PluginCategoryRow(id: String, name: String, catkey: String, sortNo: Int, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching PluginCategoryRow objects using plain SQL queries */
  implicit def GetResultPluginCategoryRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[PluginCategoryRow] = GR{
    prs => import prs._
    PluginCategoryRow.tupled((<<[String], <<[String], <<[String], <<[Int], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table plugin_category. Objects of this class serve as prototypes for rows in queries. */
  class PluginCategory(_tableTag: Tag) extends profile.api.Table[PluginCategoryRow](_tableTag, Some("aoye"), "plugin_category") {
    def * = (id, name, catkey, sortNo, description, lastModificationTime) <> (PluginCategoryRow.tupled, PluginCategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(catkey), Rep.Some(sortNo), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> PluginCategoryRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column name SqlType(VARCHAR), Length(20,true) */
    val name: Rep[String] = column[String]("name", O.Length(20,varying=true))
    /** Database column catkey SqlType(VARCHAR), Length(100,true) */
    val catkey: Rep[String] = column[String]("catkey", O.Length(100,varying=true))
    /** Database column sort_no SqlType(INT) */
    val sortNo: Rep[Int] = column[Int]("sort_no")
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")
  }
  /** Collection-like TableQuery object for table PluginCategory */
  lazy val PluginCategory = new TableQuery(tag => new PluginCategory(tag))

  /** Entity class storing rows of table PluginMain
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param pluginkey Database column pluginkey SqlType(VARCHAR), Length(50,true)
   *  @param name Database column name SqlType(VARCHAR), Length(20,true)
   *  @param categoryId Database column category_id SqlType(VARCHAR), Length(50,true)
   *  @param sortNo Database column sort_no SqlType(INT)
   *  @param version Database column version SqlType(VARCHAR), Length(20,true)
   *  @param author Database column author SqlType(VARCHAR), Length(20,true)
   *  @param editUrl Database column edit_url SqlType(VARCHAR), Length(200,true)
   *  @param designZip Database column design_zip SqlType(BLOB)
   *  @param runtimeZip Database column runtime_zip SqlType(BLOB)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class PluginMainRow(id: String, pluginkey: String, name: String, categoryId: String, sortNo: Int, version: String, author: String, editUrl: String, designZip: java.sql.Blob, runtimeZip: java.sql.Blob, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching PluginMainRow objects using plain SQL queries */
  implicit def GetResultPluginMainRow(implicit e0: GR[String], e1: GR[Int], e2: GR[java.sql.Blob], e3: GR[Option[String]], e4: GR[java.sql.Timestamp]): GR[PluginMainRow] = GR{
    prs => import prs._
    PluginMainRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[Int], <<[String], <<[String], <<[String], <<[java.sql.Blob], <<[java.sql.Blob], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table plugin_main. Objects of this class serve as prototypes for rows in queries. */
  class PluginMain(_tableTag: Tag) extends profile.api.Table[PluginMainRow](_tableTag, Some("aoye"), "plugin_main") {
    def * = (id, pluginkey, name, categoryId, sortNo, version, author, editUrl, designZip, runtimeZip, description, lastModificationTime) <> (PluginMainRow.tupled, PluginMainRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(pluginkey), Rep.Some(name), Rep.Some(categoryId), Rep.Some(sortNo), Rep.Some(version), Rep.Some(author), Rep.Some(editUrl), Rep.Some(designZip), Rep.Some(runtimeZip), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> PluginMainRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11, _12.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column pluginkey SqlType(VARCHAR), Length(50,true) */
    val pluginkey: Rep[String] = column[String]("pluginkey", O.Length(50,varying=true))
    /** Database column name SqlType(VARCHAR), Length(20,true) */
    val name: Rep[String] = column[String]("name", O.Length(20,varying=true))
    /** Database column category_id SqlType(VARCHAR), Length(50,true) */
    val categoryId: Rep[String] = column[String]("category_id", O.Length(50,varying=true))
    /** Database column sort_no SqlType(INT) */
    val sortNo: Rep[Int] = column[Int]("sort_no")
    /** Database column version SqlType(VARCHAR), Length(20,true) */
    val version: Rep[String] = column[String]("version", O.Length(20,varying=true))
    /** Database column author SqlType(VARCHAR), Length(20,true) */
    val author: Rep[String] = column[String]("author", O.Length(20,varying=true))
    /** Database column edit_url SqlType(VARCHAR), Length(200,true) */
    val editUrl: Rep[String] = column[String]("edit_url", O.Length(200,varying=true))
    /** Database column design_zip SqlType(BLOB) */
    val designZip: Rep[java.sql.Blob] = column[java.sql.Blob]("design_zip")
    /** Database column runtime_zip SqlType(BLOB) */
    val runtimeZip: Rep[java.sql.Blob] = column[java.sql.Blob]("runtime_zip")
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")
  }
  /** Collection-like TableQuery object for table PluginMain */
  lazy val PluginMain = new TableQuery(tag => new PluginMain(tag))

  /** Entity class storing rows of table Region
   *  @param regionId Database column REGION_ID SqlType(DOUBLE), PrimaryKey
   *  @param regionCode Database column REGION_CODE SqlType(VARCHAR), Length(100,true)
   *  @param regionName Database column REGION_NAME SqlType(VARCHAR), Length(100,true)
   *  @param parentId Database column PARENT_ID SqlType(DOUBLE)
   *  @param regionLevel Database column REGION_LEVEL SqlType(DOUBLE)
   *  @param regionOrder Database column REGION_ORDER SqlType(DOUBLE)
   *  @param regionNameEn Database column REGION_NAME_EN SqlType(VARCHAR), Length(100,true)
   *  @param regionShortnameEn Database column REGION_SHORTNAME_EN SqlType(VARCHAR), Length(10,true) */
  case class RegionRow(regionId: Double, regionCode: String, regionName: String, parentId: Double, regionLevel: Double, regionOrder: Double, regionNameEn: String, regionShortnameEn: String)
  /** GetResult implicit for fetching RegionRow objects using plain SQL queries */
  implicit def GetResultRegionRow(implicit e0: GR[Double], e1: GR[String]): GR[RegionRow] = GR{
    prs => import prs._
    RegionRow.tupled((<<[Double], <<[String], <<[String], <<[Double], <<[Double], <<[Double], <<[String], <<[String]))
  }
  /** Table description of table region. Objects of this class serve as prototypes for rows in queries. */
  class Region(_tableTag: Tag) extends profile.api.Table[RegionRow](_tableTag, Some("aoye"), "region") {
    def * = (regionId, regionCode, regionName, parentId, regionLevel, regionOrder, regionNameEn, regionShortnameEn) <> (RegionRow.tupled, RegionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(regionId), Rep.Some(regionCode), Rep.Some(regionName), Rep.Some(parentId), Rep.Some(regionLevel), Rep.Some(regionOrder), Rep.Some(regionNameEn), Rep.Some(regionShortnameEn)).shaped.<>({r=>import r._; _1.map(_=> RegionRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REGION_ID SqlType(DOUBLE), PrimaryKey */
    val regionId: Rep[Double] = column[Double]("REGION_ID", O.PrimaryKey)
    /** Database column REGION_CODE SqlType(VARCHAR), Length(100,true) */
    val regionCode: Rep[String] = column[String]("REGION_CODE", O.Length(100,varying=true))
    /** Database column REGION_NAME SqlType(VARCHAR), Length(100,true) */
    val regionName: Rep[String] = column[String]("REGION_NAME", O.Length(100,varying=true))
    /** Database column PARENT_ID SqlType(DOUBLE) */
    val parentId: Rep[Double] = column[Double]("PARENT_ID")
    /** Database column REGION_LEVEL SqlType(DOUBLE) */
    val regionLevel: Rep[Double] = column[Double]("REGION_LEVEL")
    /** Database column REGION_ORDER SqlType(DOUBLE) */
    val regionOrder: Rep[Double] = column[Double]("REGION_ORDER")
    /** Database column REGION_NAME_EN SqlType(VARCHAR), Length(100,true) */
    val regionNameEn: Rep[String] = column[String]("REGION_NAME_EN", O.Length(100,varying=true))
    /** Database column REGION_SHORTNAME_EN SqlType(VARCHAR), Length(10,true) */
    val regionShortnameEn: Rep[String] = column[String]("REGION_SHORTNAME_EN", O.Length(10,varying=true))
  }
  /** Collection-like TableQuery object for table Region */
  lazy val Region = new TableQuery(tag => new Region(tag))

  /** Entity class storing rows of table ResourceCategory
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param name Database column name SqlType(VARCHAR), Length(20,true)
   *  @param catkey Database column catkey SqlType(VARCHAR), Length(50,true)
   *  @param parentId Database column parent_id SqlType(VARCHAR), Length(50,true)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceCategoryRow(id: String, name: String, catkey: String, parentId: String, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceCategoryRow objects using plain SQL queries */
  implicit def GetResultResourceCategoryRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[ResourceCategoryRow] = GR{
    prs => import prs._
    ResourceCategoryRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_category. Objects of this class serve as prototypes for rows in queries. */
  class ResourceCategory(_tableTag: Tag) extends profile.api.Table[ResourceCategoryRow](_tableTag, Some("aoye"), "resource_category") {
    def * = (id, name, catkey, parentId, description, lastModificationTime) <> (ResourceCategoryRow.tupled, ResourceCategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(catkey), Rep.Some(parentId), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceCategoryRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column name SqlType(VARCHAR), Length(20,true) */
    val name: Rep[String] = column[String]("name", O.Length(20,varying=true))
    /** Database column catkey SqlType(VARCHAR), Length(50,true) */
    val catkey: Rep[String] = column[String]("catkey", O.Length(50,varying=true))
    /** Database column parent_id SqlType(VARCHAR), Length(50,true) */
    val parentId: Rep[String] = column[String]("parent_id", O.Length(50,varying=true))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")
  }
  /** Collection-like TableQuery object for table ResourceCategory */
  lazy val ResourceCategory = new TableQuery(tag => new ResourceCategory(tag))

  /** Entity class storing rows of table ResourceDb
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(50,true)
   *  @param host Database column host SqlType(VARCHAR), Length(100,true)
   *  @param `type` Database column type SqlType(VARCHAR), Length(20,true)
   *  @param port Database column port SqlType(INT)
   *  @param username Database column username SqlType(VARCHAR), Length(50,true)
   *  @param password Database column password SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param dbName Database column db_name SqlType(VARCHAR), Length(100,true)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceDbRow(id: String, reskey: String, host: String, `type`: String, port: Int, username: String, password: Option[String] = None, dbName: String, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceDbRow objects using plain SQL queries */
  implicit def GetResultResourceDbRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[ResourceDbRow] = GR{
    prs => import prs._
    ResourceDbRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[Int], <<[String], <<?[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_db. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class ResourceDb(_tableTag: Tag) extends profile.api.Table[ResourceDbRow](_tableTag, Some("aoye"), "resource_db") {
    def * = (id, reskey, host, `type`, port, username, password, dbName, lastModificationTime) <> (ResourceDbRow.tupled, ResourceDbRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), Rep.Some(host), Rep.Some(`type`), Rep.Some(port), Rep.Some(username), password, Rep.Some(dbName), Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceDbRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(50,true) */
    val reskey: Rep[String] = column[String]("reskey", O.Length(50,varying=true))
    /** Database column host SqlType(VARCHAR), Length(100,true) */
    val host: Rep[String] = column[String]("host", O.Length(100,varying=true))
    /** Database column type SqlType(VARCHAR), Length(20,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(20,varying=true))
    /** Database column port SqlType(INT) */
    val port: Rep[Int] = column[Int]("port")
    /** Database column username SqlType(VARCHAR), Length(50,true) */
    val username: Rep[String] = column[String]("username", O.Length(50,varying=true))
    /** Database column password SqlType(VARCHAR), Length(50,true), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Length(50,varying=true), O.Default(None))
    /** Database column db_name SqlType(VARCHAR), Length(100,true) */
    val dbName: Rep[String] = column[String]("db_name", O.Length(100,varying=true))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Uniqueness Index over (reskey) (database name resource_db_resid_uindex) */
    val index1 = index("resource_db_resid_uindex", reskey, unique=true)
  }
  /** Collection-like TableQuery object for table ResourceDb */
  lazy val ResourceDb = new TableQuery(tag => new ResourceDb(tag))

  /** Entity class storing rows of table ResourceDbConnPool
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(50,true), Default()
   *  @param initialSize Database column initial_size SqlType(TINYINT), Default(1)
   *  @param minIdle Database column min_idle SqlType(TINYINT), Default(1)
   *  @param maxActive Database column max_active SqlType(TINYINT), Default(8)
   *  @param maxWait Database column max_wait SqlType(INT), Default(10000)
   *  @param minEvictableIdleTimeMillis Database column min_evictable_idle_time_millis SqlType(INT), Default(30000)
   *  @param timeBetweenEvictionRunsMillis Database column time_between_eviction_runs_millis SqlType(INT), Default(60000)
   *  @param poolPreparedStatements Database column pool_prepared_statements SqlType(BIT), Default(false)
   *  @param maxmaxPoolPreparedStatementPerConnectionSize Database column maxmax_pool_prepared_statement_per_connection_size SqlType(TINYINT)
   *  @param testWhileIdle Database column test_while_idle SqlType(BIT), Default(false)
   *  @param testOnBorrow Database column test_on_borrow SqlType(BIT), Default(true)
   *  @param testOnReturn Database column test_on_return SqlType(BIT), Default(false)
   *  @param testSql Database column test_sql SqlType(VARCHAR), Length(100,true), Default()
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceDbConnPoolRow(id: String, reskey: String = "", initialSize: Byte = 1, minIdle: Byte = 1, maxActive: Byte = 8, maxWait: Int = 10000, minEvictableIdleTimeMillis: Int = 30000, timeBetweenEvictionRunsMillis: Int = 60000, poolPreparedStatements: Boolean = false, maxmaxPoolPreparedStatementPerConnectionSize: Byte, testWhileIdle: Boolean = false, testOnBorrow: Boolean = true, testOnReturn: Boolean = false, testSql: String = "", description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceDbConnPoolRow objects using plain SQL queries */
  implicit def GetResultResourceDbConnPoolRow(implicit e0: GR[String], e1: GR[Byte], e2: GR[Int], e3: GR[Boolean], e4: GR[Option[String]], e5: GR[java.sql.Timestamp]): GR[ResourceDbConnPoolRow] = GR{
    prs => import prs._
    ResourceDbConnPoolRow.tupled((<<[String], <<[String], <<[Byte], <<[Byte], <<[Byte], <<[Int], <<[Int], <<[Int], <<[Boolean], <<[Byte], <<[Boolean], <<[Boolean], <<[Boolean], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_db_conn_pool. Objects of this class serve as prototypes for rows in queries. */
  class ResourceDbConnPool(_tableTag: Tag) extends profile.api.Table[ResourceDbConnPoolRow](_tableTag, Some("aoye"), "resource_db_conn_pool") {
    def * = (id, reskey, initialSize, minIdle, maxActive, maxWait, minEvictableIdleTimeMillis, timeBetweenEvictionRunsMillis, poolPreparedStatements, maxmaxPoolPreparedStatementPerConnectionSize, testWhileIdle, testOnBorrow, testOnReturn, testSql, description, lastModificationTime) <> (ResourceDbConnPoolRow.tupled, ResourceDbConnPoolRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), Rep.Some(initialSize), Rep.Some(minIdle), Rep.Some(maxActive), Rep.Some(maxWait), Rep.Some(minEvictableIdleTimeMillis), Rep.Some(timeBetweenEvictionRunsMillis), Rep.Some(poolPreparedStatements), Rep.Some(maxmaxPoolPreparedStatementPerConnectionSize), Rep.Some(testWhileIdle), Rep.Some(testOnBorrow), Rep.Some(testOnReturn), Rep.Some(testSql), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceDbConnPoolRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15, _16.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(50,true), Default() */
    val reskey: Rep[String] = column[String]("reskey", O.Length(50,varying=true), O.Default(""))
    /** Database column initial_size SqlType(TINYINT), Default(1) */
    val initialSize: Rep[Byte] = column[Byte]("initial_size", O.Default(1))
    /** Database column min_idle SqlType(TINYINT), Default(1) */
    val minIdle: Rep[Byte] = column[Byte]("min_idle", O.Default(1))
    /** Database column max_active SqlType(TINYINT), Default(8) */
    val maxActive: Rep[Byte] = column[Byte]("max_active", O.Default(8))
    /** Database column max_wait SqlType(INT), Default(10000) */
    val maxWait: Rep[Int] = column[Int]("max_wait", O.Default(10000))
    /** Database column min_evictable_idle_time_millis SqlType(INT), Default(30000) */
    val minEvictableIdleTimeMillis: Rep[Int] = column[Int]("min_evictable_idle_time_millis", O.Default(30000))
    /** Database column time_between_eviction_runs_millis SqlType(INT), Default(60000) */
    val timeBetweenEvictionRunsMillis: Rep[Int] = column[Int]("time_between_eviction_runs_millis", O.Default(60000))
    /** Database column pool_prepared_statements SqlType(BIT), Default(false) */
    val poolPreparedStatements: Rep[Boolean] = column[Boolean]("pool_prepared_statements", O.Default(false))
    /** Database column maxmax_pool_prepared_statement_per_connection_size SqlType(TINYINT) */
    val maxmaxPoolPreparedStatementPerConnectionSize: Rep[Byte] = column[Byte]("maxmax_pool_prepared_statement_per_connection_size")
    /** Database column test_while_idle SqlType(BIT), Default(false) */
    val testWhileIdle: Rep[Boolean] = column[Boolean]("test_while_idle", O.Default(false))
    /** Database column test_on_borrow SqlType(BIT), Default(true) */
    val testOnBorrow: Rep[Boolean] = column[Boolean]("test_on_borrow", O.Default(true))
    /** Database column test_on_return SqlType(BIT), Default(false) */
    val testOnReturn: Rep[Boolean] = column[Boolean]("test_on_return", O.Default(false))
    /** Database column test_sql SqlType(VARCHAR), Length(100,true), Default() */
    val testSql: Rep[String] = column[String]("test_sql", O.Length(100,varying=true), O.Default(""))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Uniqueness Index over (reskey) (database name uniq_resource_db_conn_pool_reskey) */
    val index1 = index("uniq_resource_db_conn_pool_reskey", reskey, unique=true)
  }
  /** Collection-like TableQuery object for table ResourceDbConnPool */
  lazy val ResourceDbConnPool = new TableQuery(tag => new ResourceDbConnPool(tag))

  /** Entity class storing rows of table ResourceDbParam
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(50,true)
   *  @param name Database column name SqlType(VARCHAR), Length(100,true)
   *  @param value Database column value SqlType(VARCHAR), Length(100,true)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceDbParamRow(id: String, reskey: String, name: String, value: String, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceDbParamRow objects using plain SQL queries */
  implicit def GetResultResourceDbParamRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[ResourceDbParamRow] = GR{
    prs => import prs._
    ResourceDbParamRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_db_param. Objects of this class serve as prototypes for rows in queries. */
  class ResourceDbParam(_tableTag: Tag) extends profile.api.Table[ResourceDbParamRow](_tableTag, Some("aoye"), "resource_db_param") {
    def * = (id, reskey, name, value, description, lastModificationTime) <> (ResourceDbParamRow.tupled, ResourceDbParamRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), Rep.Some(name), Rep.Some(value), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceDbParamRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(50,true) */
    val reskey: Rep[String] = column[String]("reskey", O.Length(50,varying=true))
    /** Database column name SqlType(VARCHAR), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))
    /** Database column value SqlType(VARCHAR), Length(100,true) */
    val value: Rep[String] = column[String]("value", O.Length(100,varying=true))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")
  }
  /** Collection-like TableQuery object for table ResourceDbParam */
  lazy val ResourceDbParam = new TableQuery(tag => new ResourceDbParam(tag))

  /** Entity class storing rows of table ResourceMain
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(100,true)
   *  @param relevanceReskey Database column relevance_reskey SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(50,true)
   *  @param `type` Database column type SqlType(VARCHAR), Length(20,true)
   *  @param categoryId Database column category_id SqlType(VARCHAR), Length(50,true)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceMainRow(id: String, reskey: String, relevanceReskey: Option[String] = None, name: String, `type`: String, categoryId: String, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceMainRow objects using plain SQL queries */
  implicit def GetResultResourceMainRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[ResourceMainRow] = GR{
    prs => import prs._
    ResourceMainRow.tupled((<<[String], <<[String], <<?[String], <<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_main. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class ResourceMain(_tableTag: Tag) extends profile.api.Table[ResourceMainRow](_tableTag, Some("aoye"), "resource_main") {
    def * = (id, reskey, relevanceReskey, name, `type`, categoryId, description, lastModificationTime) <> (ResourceMainRow.tupled, ResourceMainRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), relevanceReskey, Rep.Some(name), Rep.Some(`type`), Rep.Some(categoryId), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceMainRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(100,true) */
    val reskey: Rep[String] = column[String]("reskey", O.Length(100,varying=true))
    /** Database column relevance_reskey SqlType(VARCHAR), Length(50,true), Default(None) */
    val relevanceReskey: Rep[Option[String]] = column[Option[String]]("relevance_reskey", O.Length(50,varying=true), O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("name", O.Length(50,varying=true))
    /** Database column type SqlType(VARCHAR), Length(20,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(20,varying=true))
    /** Database column category_id SqlType(VARCHAR), Length(50,true) */
    val categoryId: Rep[String] = column[String]("category_id", O.Length(50,varying=true))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Uniqueness Index over (reskey) (database name resource_main_reskey_uindex) */
    val index1 = index("resource_main_reskey_uindex", reskey, unique=true)
  }
  /** Collection-like TableQuery object for table ResourceMain */
  lazy val ResourceMain = new TableQuery(tag => new ResourceMain(tag))

  /** Entity class storing rows of table ResourceQuery
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(50,true)
   *  @param sqlQuery Database column sql_query SqlType(TEXT)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceQueryRow(id: String, reskey: String, sqlQuery: String, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceQueryRow objects using plain SQL queries */
  implicit def GetResultResourceQueryRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[ResourceQueryRow] = GR{
    prs => import prs._
    ResourceQueryRow.tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_query. Objects of this class serve as prototypes for rows in queries. */
  class ResourceQuery(_tableTag: Tag) extends profile.api.Table[ResourceQueryRow](_tableTag, Some("aoye"), "resource_query") {
    def * = (id, reskey, sqlQuery, lastModificationTime) <> (ResourceQueryRow.tupled, ResourceQueryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), Rep.Some(sqlQuery), Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceQueryRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(50,true) */
    val reskey: Rep[String] = column[String]("reskey", O.Length(50,varying=true))
    /** Database column sql_query SqlType(TEXT) */
    val sqlQuery: Rep[String] = column[String]("sql_query")
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Index over (reskey) (database name idx_reskey) */
    val index1 = index("idx_reskey", reskey)
  }
  /** Collection-like TableQuery object for table ResourceQuery */
  lazy val ResourceQuery = new TableQuery(tag => new ResourceQuery(tag))

  /** Entity class storing rows of table ResourceQueryParam
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(50,true)
   *  @param name Database column name SqlType(VARCHAR), Length(200,true)
   *  @param `type` Database column type SqlType(VARCHAR), Length(50,true)
   *  @param defaultValue Database column default_value SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceQueryParamRow(id: String, reskey: String, name: String, `type`: String, defaultValue: Option[String] = None, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceQueryParamRow objects using plain SQL queries */
  implicit def GetResultResourceQueryParamRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[ResourceQueryParamRow] = GR{
    prs => import prs._
    ResourceQueryParamRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_query_param. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class ResourceQueryParam(_tableTag: Tag) extends profile.api.Table[ResourceQueryParamRow](_tableTag, Some("aoye"), "resource_query_param") {
    def * = (id, reskey, name, `type`, defaultValue, description, lastModificationTime) <> (ResourceQueryParamRow.tupled, ResourceQueryParamRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), Rep.Some(name), Rep.Some(`type`), defaultValue, description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceQueryParamRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(50,true) */
    val reskey: Rep[String] = column[String]("reskey", O.Length(50,varying=true))
    /** Database column name SqlType(VARCHAR), Length(200,true) */
    val name: Rep[String] = column[String]("name", O.Length(200,varying=true))
    /** Database column type SqlType(VARCHAR), Length(50,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(50,varying=true))
    /** Database column default_value SqlType(VARCHAR), Length(200,true), Default(None) */
    val defaultValue: Rep[Option[String]] = column[Option[String]]("default_value", O.Length(200,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Index over (reskey) (database name idx_reskey) */
    val index1 = index("idx_reskey", reskey)
  }
  /** Collection-like TableQuery object for table ResourceQueryParam */
  lazy val ResourceQueryParam = new TableQuery(tag => new ResourceQueryParam(tag))

  /** Entity class storing rows of table ResourceQueryReference
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(50,true)
   *  @param referenceReskey Database column reference_reskey SqlType(VARCHAR), Length(50,true)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceQueryReferenceRow(id: String, reskey: String, referenceReskey: String, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceQueryReferenceRow objects using plain SQL queries */
  implicit def GetResultResourceQueryReferenceRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[ResourceQueryReferenceRow] = GR{
    prs => import prs._
    ResourceQueryReferenceRow.tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_query_reference. Objects of this class serve as prototypes for rows in queries. */
  class ResourceQueryReference(_tableTag: Tag) extends profile.api.Table[ResourceQueryReferenceRow](_tableTag, Some("aoye"), "resource_query_reference") {
    def * = (id, reskey, referenceReskey, lastModificationTime) <> (ResourceQueryReferenceRow.tupled, ResourceQueryReferenceRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), Rep.Some(referenceReskey), Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceQueryReferenceRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(50,true) */
    val reskey: Rep[String] = column[String]("reskey", O.Length(50,varying=true))
    /** Database column reference_reskey SqlType(VARCHAR), Length(50,true) */
    val referenceReskey: Rep[String] = column[String]("reference_reskey", O.Length(50,varying=true))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Index over (reskey) (database name idx_reskey) */
    val index1 = index("idx_reskey", reskey)
  }
  /** Collection-like TableQuery object for table ResourceQueryReference */
  lazy val ResourceQueryReference = new TableQuery(tag => new ResourceQueryReference(tag))

  /** Entity class storing rows of table ResourceTable
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(50,true)
   *  @param tableNameX Database column table_name SqlType(VARCHAR), Length(255,true)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceTableRow(id: String, reskey: String, tableNameX: String, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceTableRow objects using plain SQL queries */
  implicit def GetResultResourceTableRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[ResourceTableRow] = GR{
    prs => import prs._
    ResourceTableRow.tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_table. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala method names and were disambiguated: tableName */
  class ResourceTable(_tableTag: Tag) extends profile.api.Table[ResourceTableRow](_tableTag, Some("aoye"), "resource_table") {
    def * = (id, reskey, tableNameX, lastModificationTime) <> (ResourceTableRow.tupled, ResourceTableRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), Rep.Some(tableNameX), Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceTableRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(50,true) */
    val reskey: Rep[String] = column[String]("reskey", O.Length(50,varying=true))
    /** Database column table_name SqlType(VARCHAR), Length(255,true)
     *  NOTE: The name was disambiguated because it collided with Slick's method Table#tableName. */
    val tableNameX: Rep[String] = column[String]("table_name", O.Length(255,varying=true))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Index over (reskey) (database name idx_reskey) */
    val index1 = index("idx_reskey", reskey)
  }
  /** Collection-like TableQuery object for table ResourceTable */
  lazy val ResourceTable = new TableQuery(tag => new ResourceTable(tag))

  /** Entity class storing rows of table ResourceTableColumn
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param reskey Database column reskey SqlType(VARCHAR), Length(50,true)
   *  @param originalName Database column original_name SqlType(VARCHAR), Length(255,true)
   *  @param name Database column name SqlType(VARCHAR), Length(50,true)
   *  @param originalType Database column original_type SqlType(VARCHAR), Length(255,true)
   *  @param `type` Database column type SqlType(VARCHAR), Length(255,true)
   *  @param isIdentification Database column is_identification SqlType(BIT), Default(false)
   *  @param isNullable Database column is_nullable SqlType(BIT), Default(false)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ResourceTableColumnRow(id: String, reskey: String, originalName: String, name: String, originalType: String, `type`: String, isIdentification: Boolean = false, isNullable: Boolean = false, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ResourceTableColumnRow objects using plain SQL queries */
  implicit def GetResultResourceTableColumnRow(implicit e0: GR[String], e1: GR[Boolean], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[ResourceTableColumnRow] = GR{
    prs => import prs._
    ResourceTableColumnRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Boolean], <<[Boolean], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table resource_table_column. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class ResourceTableColumn(_tableTag: Tag) extends profile.api.Table[ResourceTableColumnRow](_tableTag, Some("aoye"), "resource_table_column") {
    def * = (id, reskey, originalName, name, originalType, `type`, isIdentification, isNullable, description, lastModificationTime) <> (ResourceTableColumnRow.tupled, ResourceTableColumnRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(reskey), Rep.Some(originalName), Rep.Some(name), Rep.Some(originalType), Rep.Some(`type`), Rep.Some(isIdentification), Rep.Some(isNullable), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ResourceTableColumnRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column reskey SqlType(VARCHAR), Length(50,true) */
    val reskey: Rep[String] = column[String]("reskey", O.Length(50,varying=true))
    /** Database column original_name SqlType(VARCHAR), Length(255,true) */
    val originalName: Rep[String] = column[String]("original_name", O.Length(255,varying=true))
    /** Database column name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("name", O.Length(50,varying=true))
    /** Database column original_type SqlType(VARCHAR), Length(255,true) */
    val originalType: Rep[String] = column[String]("original_type", O.Length(255,varying=true))
    /** Database column type SqlType(VARCHAR), Length(255,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(255,varying=true))
    /** Database column is_identification SqlType(BIT), Default(false) */
    val isIdentification: Rep[Boolean] = column[Boolean]("is_identification", O.Default(false))
    /** Database column is_nullable SqlType(BIT), Default(false) */
    val isNullable: Rep[Boolean] = column[Boolean]("is_nullable", O.Default(false))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Index over (reskey) (database name idx_reskey) */
    val index1 = index("idx_reskey", reskey)
  }
  /** Collection-like TableQuery object for table ResourceTableColumn */
  lazy val ResourceTableColumn = new TableQuery(tag => new ResourceTableColumn(tag))

  /** Entity class storing rows of table ServiceAuthorization
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param servkey Database column servkey SqlType(VARCHAR), Length(50,true)
   *  @param departmentId Database column department_id SqlType(VARCHAR), Length(50,true)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ServiceAuthorizationRow(id: String, servkey: String, departmentId: String, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ServiceAuthorizationRow objects using plain SQL queries */
  implicit def GetResultServiceAuthorizationRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[ServiceAuthorizationRow] = GR{
    prs => import prs._
    ServiceAuthorizationRow.tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table service_authorization. Objects of this class serve as prototypes for rows in queries. */
  class ServiceAuthorization(_tableTag: Tag) extends profile.api.Table[ServiceAuthorizationRow](_tableTag, Some("aoye"), "service_authorization") {
    def * = (id, servkey, departmentId, lastModificationTime) <> (ServiceAuthorizationRow.tupled, ServiceAuthorizationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(servkey), Rep.Some(departmentId), Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ServiceAuthorizationRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column servkey SqlType(VARCHAR), Length(50,true) */
    val servkey: Rep[String] = column[String]("servkey", O.Length(50,varying=true))
    /** Database column department_id SqlType(VARCHAR), Length(50,true) */
    val departmentId: Rep[String] = column[String]("department_id", O.Length(50,varying=true))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Index over (servkey) (database name idx_servkey) */
    val index1 = index("idx_servkey", servkey)
  }
  /** Collection-like TableQuery object for table ServiceAuthorization */
  lazy val ServiceAuthorization = new TableQuery(tag => new ServiceAuthorization(tag))

  /** Entity class storing rows of table ServiceCategory
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param name Database column name SqlType(VARCHAR), Length(20,true)
   *  @param catkey Database column catkey SqlType(VARCHAR), Length(50,true)
   *  @param parentId Database column parent_id SqlType(VARCHAR), Length(50,true)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ServiceCategoryRow(id: String, name: String, catkey: String, parentId: String, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ServiceCategoryRow objects using plain SQL queries */
  implicit def GetResultServiceCategoryRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[ServiceCategoryRow] = GR{
    prs => import prs._
    ServiceCategoryRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table service_category. Objects of this class serve as prototypes for rows in queries. */
  class ServiceCategory(_tableTag: Tag) extends profile.api.Table[ServiceCategoryRow](_tableTag, Some("aoye"), "service_category") {
    def * = (id, name, catkey, parentId, description, lastModificationTime) <> (ServiceCategoryRow.tupled, ServiceCategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(catkey), Rep.Some(parentId), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ServiceCategoryRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column name SqlType(VARCHAR), Length(20,true) */
    val name: Rep[String] = column[String]("name", O.Length(20,varying=true))
    /** Database column catkey SqlType(VARCHAR), Length(50,true) */
    val catkey: Rep[String] = column[String]("catkey", O.Length(50,varying=true))
    /** Database column parent_id SqlType(VARCHAR), Length(50,true) */
    val parentId: Rep[String] = column[String]("parent_id", O.Length(50,varying=true))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Uniqueness Index over (catkey) (database name uni_catkey) */
    val index1 = index("uni_catkey", catkey, unique=true)
  }
  /** Collection-like TableQuery object for table ServiceCategory */
  lazy val ServiceCategory = new TableQuery(tag => new ServiceCategory(tag))

  /** Entity class storing rows of table ServiceMain
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param servkey Database column servkey SqlType(VARCHAR), Length(100,true)
   *  @param name Database column name SqlType(VARCHAR), Length(20,true)
   *  @param categoryId Database column category_id SqlType(VARCHAR), Length(50,true)
   *  @param `type` Database column type SqlType(VARCHAR), Length(20,true)
   *  @param providerId Database column provider_id SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param receiverId Database column receiver_id SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param publishVersionId Database column publish_version_id SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param publishUserId Database column publish_user_id SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param publishDatetime Database column publish_datetime SqlType(DATETIME), Default(None)
   *  @param sample Database column sample SqlType(TEXT), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ServiceMainRow(id: String, servkey: String, name: String, categoryId: String, `type`: String, providerId: Option[String] = None, receiverId: Option[String] = None, publishVersionId: Option[String] = None, publishUserId: Option[String] = None, publishDatetime: Option[java.sql.Timestamp] = None, sample: Option[String] = None, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ServiceMainRow objects using plain SQL queries */
  implicit def GetResultServiceMainRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]], e3: GR[java.sql.Timestamp]): GR[ServiceMainRow] = GR{
    prs => import prs._
    ServiceMainRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table service_main. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class ServiceMain(_tableTag: Tag) extends profile.api.Table[ServiceMainRow](_tableTag, Some("aoye"), "service_main") {
    def * = (id, servkey, name, categoryId, `type`, providerId, receiverId, publishVersionId, publishUserId, publishDatetime, sample, description, lastModificationTime) <> (ServiceMainRow.tupled, ServiceMainRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(servkey), Rep.Some(name), Rep.Some(categoryId), Rep.Some(`type`), providerId, receiverId, publishVersionId, publishUserId, publishDatetime, sample, description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ServiceMainRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7, _8, _9, _10, _11, _12, _13.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column servkey SqlType(VARCHAR), Length(100,true) */
    val servkey: Rep[String] = column[String]("servkey", O.Length(100,varying=true))
    /** Database column name SqlType(VARCHAR), Length(20,true) */
    val name: Rep[String] = column[String]("name", O.Length(20,varying=true))
    /** Database column category_id SqlType(VARCHAR), Length(50,true) */
    val categoryId: Rep[String] = column[String]("category_id", O.Length(50,varying=true))
    /** Database column type SqlType(VARCHAR), Length(20,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(20,varying=true))
    /** Database column provider_id SqlType(VARCHAR), Length(50,true), Default(None) */
    val providerId: Rep[Option[String]] = column[Option[String]]("provider_id", O.Length(50,varying=true), O.Default(None))
    /** Database column receiver_id SqlType(VARCHAR), Length(50,true), Default(None) */
    val receiverId: Rep[Option[String]] = column[Option[String]]("receiver_id", O.Length(50,varying=true), O.Default(None))
    /** Database column publish_version_id SqlType(VARCHAR), Length(50,true), Default(None) */
    val publishVersionId: Rep[Option[String]] = column[Option[String]]("publish_version_id", O.Length(50,varying=true), O.Default(None))
    /** Database column publish_user_id SqlType(VARCHAR), Length(50,true), Default(None) */
    val publishUserId: Rep[Option[String]] = column[Option[String]]("publish_user_id", O.Length(50,varying=true), O.Default(None))
    /** Database column publish_datetime SqlType(DATETIME), Default(None) */
    val publishDatetime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("publish_datetime", O.Default(None))
    /** Database column sample SqlType(TEXT), Default(None) */
    val sample: Rep[Option[String]] = column[Option[String]]("sample", O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Uniqueness Index over (servkey) (database name service_main_servkey_uindex) */
    val index1 = index("service_main_servkey_uindex", servkey, unique=true)
  }
  /** Collection-like TableQuery object for table ServiceMain */
  lazy val ServiceMain = new TableQuery(tag => new ServiceMain(tag))

  /** Entity class storing rows of table ServiceVersion
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param servkey Database column servkey SqlType(VARCHAR), Length(50,true)
   *  @param number Database column number SqlType(VARCHAR), Length(20,true)
   *  @param editUserId Database column edit_user_id SqlType(VARCHAR), Length(50,true)
   *  @param editDatetime Database column edit_datetime SqlType(DATETIME)
   *  @param jsonFile Database column json_file SqlType(BLOB)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class ServiceVersionRow(id: String, servkey: String, number: String, editUserId: String, editDatetime: java.sql.Timestamp, jsonFile: java.sql.Blob, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching ServiceVersionRow objects using plain SQL queries */
  implicit def GetResultServiceVersionRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp], e2: GR[java.sql.Blob]): GR[ServiceVersionRow] = GR{
    prs => import prs._
    ServiceVersionRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Blob], <<[java.sql.Timestamp]))
  }
  /** Table description of table service_version. Objects of this class serve as prototypes for rows in queries. */
  class ServiceVersion(_tableTag: Tag) extends profile.api.Table[ServiceVersionRow](_tableTag, Some("aoye"), "service_version") {
    def * = (id, servkey, number, editUserId, editDatetime, jsonFile, lastModificationTime) <> (ServiceVersionRow.tupled, ServiceVersionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(servkey), Rep.Some(number), Rep.Some(editUserId), Rep.Some(editDatetime), Rep.Some(jsonFile), Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> ServiceVersionRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column servkey SqlType(VARCHAR), Length(50,true) */
    val servkey: Rep[String] = column[String]("servkey", O.Length(50,varying=true))
    /** Database column number SqlType(VARCHAR), Length(20,true) */
    val number: Rep[String] = column[String]("number", O.Length(20,varying=true))
    /** Database column edit_user_id SqlType(VARCHAR), Length(50,true) */
    val editUserId: Rep[String] = column[String]("edit_user_id", O.Length(50,varying=true))
    /** Database column edit_datetime SqlType(DATETIME) */
    val editDatetime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("edit_datetime")
    /** Database column json_file SqlType(BLOB) */
    val jsonFile: Rep[java.sql.Blob] = column[java.sql.Blob]("json_file")
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Index over (servkey) (database name idx_servkey) */
    val index1 = index("idx_servkey", servkey)
  }
  /** Collection-like TableQuery object for table ServiceVersion */
  lazy val ServiceVersion = new TableQuery(tag => new ServiceVersion(tag))

  /** Entity class storing rows of table SystemDepartment
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param name Database column name SqlType(VARCHAR), Length(100,true)
   *  @param deptkey Database column deptkey SqlType(VARCHAR), Length(50,true)
   *  @param token Database column token SqlType(VARCHAR), Length(50,true)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class SystemDepartmentRow(id: String, name: String, deptkey: String, token: String, description: Option[String] = None, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching SystemDepartmentRow objects using plain SQL queries */
  implicit def GetResultSystemDepartmentRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[SystemDepartmentRow] = GR{
    prs => import prs._
    SystemDepartmentRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table system_department. Objects of this class serve as prototypes for rows in queries. */
  class SystemDepartment(_tableTag: Tag) extends profile.api.Table[SystemDepartmentRow](_tableTag, Some("aoye"), "system_department") {
    def * = (id, name, deptkey, token, description, lastModificationTime) <> (SystemDepartmentRow.tupled, SystemDepartmentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(deptkey), Rep.Some(token), description, Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> SystemDepartmentRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column name SqlType(VARCHAR), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))
    /** Database column deptkey SqlType(VARCHAR), Length(50,true) */
    val deptkey: Rep[String] = column[String]("deptkey", O.Length(50,varying=true))
    /** Database column token SqlType(VARCHAR), Length(50,true) */
    val token: Rep[String] = column[String]("token", O.Length(50,varying=true))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Uniqueness Index over (deptkey) (database name idx_deptkey) */
    val index1 = index("idx_deptkey", deptkey, unique=true)
  }
  /** Collection-like TableQuery object for table SystemDepartment */
  lazy val SystemDepartment = new TableQuery(tag => new SystemDepartment(tag))

  /** Entity class storing rows of table SystemOperationLog
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(50,true)
   *  @param operationTime Database column operation_time SqlType(TIMESTAMP)
   *  @param clientIp Database column client_ip SqlType(VARCHAR), Length(50,true)
   *  @param module Database column module SqlType(VARCHAR), Length(100,true)
   *  @param operationType Database column operation_type SqlType(VARCHAR), Length(100,true) */
  case class SystemOperationLogRow(id: String, userId: String, operationTime: java.sql.Timestamp, clientIp: String, module: String, operationType: String)
  /** GetResult implicit for fetching SystemOperationLogRow objects using plain SQL queries */
  implicit def GetResultSystemOperationLogRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[SystemOperationLogRow] = GR{
    prs => import prs._
    SystemOperationLogRow.tupled((<<[String], <<[String], <<[java.sql.Timestamp], <<[String], <<[String], <<[String]))
  }
  /** Table description of table system_operation_log. Objects of this class serve as prototypes for rows in queries. */
  class SystemOperationLog(_tableTag: Tag) extends profile.api.Table[SystemOperationLogRow](_tableTag, Some("aoye"), "system_operation_log") {
    def * = (id, userId, operationTime, clientIp, module, operationType) <> (SystemOperationLogRow.tupled, SystemOperationLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userId), Rep.Some(operationTime), Rep.Some(clientIp), Rep.Some(module), Rep.Some(operationType)).shaped.<>({r=>import r._; _1.map(_=> SystemOperationLogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column user_id SqlType(VARCHAR), Length(50,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(50,varying=true))
    /** Database column operation_time SqlType(TIMESTAMP) */
    val operationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("operation_time")
    /** Database column client_ip SqlType(VARCHAR), Length(50,true) */
    val clientIp: Rep[String] = column[String]("client_ip", O.Length(50,varying=true))
    /** Database column module SqlType(VARCHAR), Length(100,true) */
    val module: Rep[String] = column[String]("module", O.Length(100,varying=true))
    /** Database column operation_type SqlType(VARCHAR), Length(100,true) */
    val operationType: Rep[String] = column[String]("operation_type", O.Length(100,varying=true))
  }
  /** Collection-like TableQuery object for table SystemOperationLog */
  lazy val SystemOperationLog = new TableQuery(tag => new SystemOperationLog(tag))

  /** Entity class storing rows of table SystemOperationParam
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param logId Database column log_id SqlType(VARCHAR), Length(50,true)
   *  @param requestParam Database column request_param SqlType(TEXT), Default(None)
   *  @param responseParam Database column response_param SqlType(TEXT), Default(None) */
  case class SystemOperationParamRow(id: String, logId: String, requestParam: Option[String] = None, responseParam: Option[String] = None)
  /** GetResult implicit for fetching SystemOperationParamRow objects using plain SQL queries */
  implicit def GetResultSystemOperationParamRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[SystemOperationParamRow] = GR{
    prs => import prs._
    SystemOperationParamRow.tupled((<<[String], <<[String], <<?[String], <<?[String]))
  }
  /** Table description of table system_operation_param. Objects of this class serve as prototypes for rows in queries. */
  class SystemOperationParam(_tableTag: Tag) extends profile.api.Table[SystemOperationParamRow](_tableTag, Some("aoye"), "system_operation_param") {
    def * = (id, logId, requestParam, responseParam) <> (SystemOperationParamRow.tupled, SystemOperationParamRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(logId), requestParam, responseParam).shaped.<>({r=>import r._; _1.map(_=> SystemOperationParamRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column log_id SqlType(VARCHAR), Length(50,true) */
    val logId: Rep[String] = column[String]("log_id", O.Length(50,varying=true))
    /** Database column request_param SqlType(TEXT), Default(None) */
    val requestParam: Rep[Option[String]] = column[Option[String]]("request_param", O.Default(None))
    /** Database column response_param SqlType(TEXT), Default(None) */
    val responseParam: Rep[Option[String]] = column[Option[String]]("response_param", O.Default(None))
  }
  /** Collection-like TableQuery object for table SystemOperationParam */
  lazy val SystemOperationParam = new TableQuery(tag => new SystemOperationParam(tag))

  /** Entity class storing rows of table SystemUser
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param username Database column username SqlType(VARCHAR), Length(50,true)
   *  @param password Database column password SqlType(VARCHAR), Length(50,true)
   *  @param isDisabled Database column is_disabled SqlType(BIT), Default(false)
   *  @param lastModificationTime Database column last_modification_time SqlType(TIMESTAMP) */
  case class SystemUserRow(id: String, username: String, password: String, isDisabled: Boolean = false, lastModificationTime: java.sql.Timestamp)
  /** GetResult implicit for fetching SystemUserRow objects using plain SQL queries */
  implicit def GetResultSystemUserRow(implicit e0: GR[String], e1: GR[Boolean], e2: GR[java.sql.Timestamp]): GR[SystemUserRow] = GR{
    prs => import prs._
    SystemUserRow.tupled((<<[String], <<[String], <<[String], <<[Boolean], <<[java.sql.Timestamp]))
  }
  /** Table description of table system_user. Objects of this class serve as prototypes for rows in queries. */
  class SystemUser(_tableTag: Tag) extends profile.api.Table[SystemUserRow](_tableTag, Some("aoye"), "system_user") {
    def * = (id, username, password, isDisabled, lastModificationTime) <> (SystemUserRow.tupled, SystemUserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(username), Rep.Some(password), Rep.Some(isDisabled), Rep.Some(lastModificationTime)).shaped.<>({r=>import r._; _1.map(_=> SystemUserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(50,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column username SqlType(VARCHAR), Length(50,true) */
    val username: Rep[String] = column[String]("username", O.Length(50,varying=true))
    /** Database column password SqlType(VARCHAR), Length(50,true) */
    val password: Rep[String] = column[String]("password", O.Length(50,varying=true))
    /** Database column is_disabled SqlType(BIT), Default(false) */
    val isDisabled: Rep[Boolean] = column[Boolean]("is_disabled", O.Default(false))
    /** Database column last_modification_time SqlType(TIMESTAMP) */
    val lastModificationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_modification_time")

    /** Uniqueness Index over (username) (database name idx_username) */
    val index1 = index("idx_username", username, unique=true)
  }
  /** Collection-like TableQuery object for table SystemUser */
  lazy val SystemUser = new TableQuery(tag => new SystemUser(tag))

  /** Entity class storing rows of table Testtable
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(TEXT) */
  case class TesttableRow(id: Long, name: String)
  /** GetResult implicit for fetching TesttableRow objects using plain SQL queries */
  implicit def GetResultTesttableRow(implicit e0: GR[Long], e1: GR[String]): GR[TesttableRow] = GR{
    prs => import prs._
    TesttableRow.tupled((<<[Long], <<[String]))
  }
  /** Table description of table TestTable. Objects of this class serve as prototypes for rows in queries. */
  class Testtable(_tableTag: Tag) extends profile.api.Table[TesttableRow](_tableTag, Some("aoye"), "TestTable") {
    def * = (id, name) <> (TesttableRow.tupled, TesttableRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> TesttableRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(TEXT) */
    val name: Rep[String] = column[String]("name")
  }
  /** Collection-like TableQuery object for table Testtable */
  lazy val Testtable = new TableQuery(tag => new Testtable(tag))

  /** Entity class storing rows of table User
   *  @param testId Database column test_id SqlType(BIGINT), PrimaryKey
   *  @param tenantId Database column tenant_id SqlType(BIGINT)
   *  @param name Database column name SqlType(VARCHAR), Length(30,true)
   *  @param age Database column age SqlType(INT), Default(None)
   *  @param testType Database column test_type SqlType(INT), Default(None)
   *  @param testDate Database column test_date SqlType(DATETIME), Default(None)
   *  @param role Database column role SqlType(BIGINT), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(11,true), Default(None) */
  case class UserRow(testId: Long, tenantId: Long, name: String, age: Option[Int] = None, testType: Option[Int] = None, testDate: Option[java.sql.Timestamp] = None, role: Option[Long] = None, phone: Option[String] = None)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[Int]], e3: GR[Option[java.sql.Timestamp]], e4: GR[Option[Long]], e5: GR[Option[String]]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Long], <<[Long], <<[String], <<?[Int], <<?[Int], <<?[java.sql.Timestamp], <<?[Long], <<?[String]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends profile.api.Table[UserRow](_tableTag, Some("aoye"), "user") {
    def * = (testId, tenantId, name, age, testType, testDate, role, phone) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(testId), Rep.Some(tenantId), Rep.Some(name), age, testType, testDate, role, phone).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column test_id SqlType(BIGINT), PrimaryKey */
    val testId: Rep[Long] = column[Long]("test_id", O.PrimaryKey)
    /** Database column tenant_id SqlType(BIGINT) */
    val tenantId: Rep[Long] = column[Long]("tenant_id")
    /** Database column name SqlType(VARCHAR), Length(30,true) */
    val name: Rep[String] = column[String]("name", O.Length(30,varying=true))
    /** Database column age SqlType(INT), Default(None) */
    val age: Rep[Option[Int]] = column[Option[Int]]("age", O.Default(None))
    /** Database column test_type SqlType(INT), Default(None) */
    val testType: Rep[Option[Int]] = column[Option[Int]]("test_type", O.Default(None))
    /** Database column test_date SqlType(DATETIME), Default(None) */
    val testDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("test_date", O.Default(None))
    /** Database column role SqlType(BIGINT), Default(None) */
    val role: Rep[Option[Long]] = column[Option[Long]]("role", O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(11,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(11,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
