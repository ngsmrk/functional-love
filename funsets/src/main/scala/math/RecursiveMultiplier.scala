package math

import scala.annotation.tailrec

class RecursiveMultiplier extends Multiplier {
  override def multiply(x: Int, y: Int): Int = {

    @tailrec
    def iter(increment: Int, y: Int, accumulator: Int): Int = {
      if (y == 0) accumulator
      else iter(increment, y-1, accumulator + increment)
    }

    iter(x, y, 0)
  }
}