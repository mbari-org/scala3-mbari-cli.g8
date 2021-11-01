package $package$

import java.util.concurrent.Callable
import picocli.CommandLine
import picocli.CommandLine.{Command, Option => Opt, Parameters}

@Command(
  description = Array("A Main app"),
  name = "main",
  mixinStandardHelpOptions = true,
  version = Array("0.0.1")
)
class MainRunner extends Callable[Int]:

  @Parameters(index = "0", description = Array("A message"))
  private var message: String = _

  override def call(): Int = 
    Main.run(message)
    0

object Main:

  def main(args: Array[String]): Unit = 
    new CommandLine(new MainRunner()).execute(args: _*)

  def run(msg: String): Unit = println(msg)
    
  