package $package$

import mainargs.arg
import mainargs.ParserForMethods

object Main:

  def main(args: Array[String]): Unit = 
    ParserForMethods(this).runOrExit(args.toSeq)
    System.exit(0)

  @mainargs.main(
    name = "main-runner",
    doc = "A main app"
  )
  def run(
    @arg(positional = true, doc = "A message") msg: String
  ): Unit = println(msg)
  