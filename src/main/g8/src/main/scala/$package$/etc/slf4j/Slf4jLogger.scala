package $package$.etc.slf4j

import java.lang.System.Logger.Level
import java.util.ResourceBundle
import java.text.MessageFormat
import scala.beans.BeanProperty

class Slf4jLogger(@BeanProperty val name: String) extends System.Logger:
 
  private val logger = org.slf4j.LoggerFactory.getLogger(name)

  override def isLoggable(level: Level): Boolean =
    level match
      case Level.OFF => false
      case Level.TRACE => logger.isTraceEnabled
      case Level.DEBUG => logger.isDebugEnabled
      case Level.INFO => logger.isInfoEnabled
      case Level.WARNING => logger.isWarnEnabled
      case Level.ERROR => logger.isErrorEnabled
      case _ => true

  override def log(level: Level, bundle: ResourceBundle, msg: String, thrown: Throwable): Unit =
    if (isLoggable(level))
      level match 
        case Level.OFF => // Do nothing
        case Level.TRACE => logger.trace(msg, thrown)
        case Level.DEBUG => logger.debug(msg, thrown)
        case Level.INFO => logger.info(msg, thrown)
        case Level.WARNING => logger.warn(msg, thrown)
        case Level.ERROR => logger.error(msg, thrown)
        case _ => logger.info(msg, thrown)

  override def log(level: Level, bundle: ResourceBundle, format: String, params: Any*): Unit =
    if (isLoggable(level))
      var msg = if params != null then MessageFormat.format(format, params: _*) else format
      level match 
        case Level.OFF => // Do nothing
        case Level.TRACE => logger.trace(msg)
        case Level.DEBUG => logger.debug(msg)
        case Level.INFO => logger.info(msg)
        case Level.WARNING => logger.warn(msg)
        case Level.ERROR => logger.error(msg)
        case _ => logger.info(msg)

