package $package$

import com.typesafe.config.ConfigFactory
import scala.util.Try

object AppConfig {

  val Config = ConfigFactory.load()

  val Name: String = "$name$"

  val Version: String = Try(getClass.getPackage.getImplementationVersion).getOrElse("0.0.0-SNAPSHOT")
  
}
