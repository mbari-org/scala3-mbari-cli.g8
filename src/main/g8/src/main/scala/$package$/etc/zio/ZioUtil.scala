package $package$.etc.zio

import zio.{Unsafe, ZIO}

object ZioUtil:

  def unsafeRun[E, A](app: ZIO[Any, E, A]): A =
    Unsafe.unsafe(zio.Runtime.default.unsafe.run(app).getOrThrowFiberFailure())
