package math

import scala.annotation.tailrec

class RecursiveMultiplier extends Multiplier {
  override def multiply(x: Int, y: Int): Int = {

    @tailrec
    def iter(x: Int, y: Int, accumulator: Int): Int = {
      if (y == 0) accumulator
      else iter(x, y-1, accumulator + x)
    }

    iter(x, y, 0)
  }
}