package $package$.etc.sdk

import java.time.Duration
import java.util.concurrent.{Executors, TimeUnit}
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.Duration as SDuration
import scala.util.Try

class Futures:
  val DefaultTimeout = Duration.ofSeconds(10)

    /**
     * Run a Future and return the result or an Exception if the Future fails or does not complete within the timeout
     *
     * @param f
     *   A function that returns a Future
     * @param timeout
     *   The maximum amount of time to wait for the Future to complete
     * @tparam T
     *   The type that the Future returns
     * @return
     *   The result of the Future or an Exception
     */
    def safeRunSync[T](f: => Future[T], timeout: Duration)(using ec: ExecutionContext): Either[Throwable, T] =
        Try(Await.result(f, SDuration(timeout.toMillis, TimeUnit.MILLISECONDS))).toEither

    extension [T](f: Future[T])
        def join: T                      = Await.result(t, DefaultTimeout)
        def join(duration: Duration): T  = Await.result(t, duration)
        def join(duration: JDuration): T = Await.result(t, Duration.fromNanos(duration.toNanos))
        def safeRunSync(timeout: Duration = DefaultTimeout)(using ec: ExecutionContext): Either[Throwable, T] =
            Futures.safeRunSync(f, timeout)