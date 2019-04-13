package husarz.sample

/**
  * @author ${user.name}
  */
object App {

  def concatenation(x: Array[String]) = x.foldLeft("")((a, b) => a + b)

  def sum(x: Array[String]) = x.map(_.toInt).sum

  def main(args: Array[String]) {
    println("Hello World!")
    println("concat arguments = " + concatenation(args))
    println("sum Int arguments = " + sum(args))
  }

}
