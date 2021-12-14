package $package$.etc.slf4j

class Slf4jLoggerFinder extends System.LoggerFinder:
  override def getLogger(name: String, module: Module): System.Logger =
    new Slf4jLogger(name)
