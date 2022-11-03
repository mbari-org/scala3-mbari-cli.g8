package $package$.etc.zio

import zio.*
import $package$.etc.jdk.Logging.given
import zio.Cause.Die

object ZioUtil:

  private val log = java.lang.System.getLogger(getClass.getName)

  /**
   * Run the given effect. Throws an exception if the effect fails.
   *
   * @param app
   *   The effect to run
   * @return
   *   The result of the effect
   */
  def unsafeRun[E, A](app: ZIO[Any, E, A]): A =
    Unsafe.unsafe { implicit unsafe =>
      Runtime.default.unsafe.run(app).getOrThrowFiberFailure()
    }

  /**
   * Run the given effect.
   *
   * @param app
   *   The effect to run
   * @return
   *   The result of the effect. Some on success. None on Failure
   */
  def safeRun[E, A](app: ZIO[Any, E, A]): Option[A] =
    Unsafe.unsafe { implicit unsafe =>
      Runtime.default.unsafe.run(app) match
        case Exit.Success(a) => Some(a)
        case Exit.Failure(e) =>
          e match
            case d: Die => log.atError.withCause(d.value).log(e.toString)
            case _      => log.atError.log(e.toString)
          None
    }

