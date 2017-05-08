import scala.annotation.tailrec

object math {

  def multiply(x: Int, y: Int): Int = {
    var acc = 0

    for (i <- 1 to y) {
      acc += x
    }

    acc
  }

  def recursiveMultiplication(x: Int, y: Int): Int = {
    var acc = 0

    @tailrec
    def iterMulti(x: Int, y:Int): Int = {
      println("x = " + x + "y = " + y)
      if (y == 0) return 0
      else acc += x ; iterMulti(x, y-1)
    }

    iterMulti(x, y)

    acc
  }

  def recursiveMultiplicationVariant(x: Int, y: Int): Int = {

    @tailrec
    def iterMulti(x: Int, y:Int, acc: Int): Int = {
      println("x = " + x + " y = " + y + " acc " + acc)
      if (y == 0) acc
      else iterMulti(x, y-1, acc + x)
    }

    iterMulti(x, y, 0)
  }

  // multiply(8, 3)
  recursiveMultiplicationVariant(8,3)
}
