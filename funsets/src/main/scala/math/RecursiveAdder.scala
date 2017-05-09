package math

import scala.annotation.tailrec

/**
  * . 
  *
  * @author Initial: amark
  * @version 1.0
  */
class RecursiveAdder extends Adder {
  override def add(x: Int, y: Int): Int = {

    @tailrec
    def iter(increment: Int, y:Int, accumulator: Int): Int = {
      if (y==0) accumulator
      else iter(increment, y-1, accumulator+1)
    }

    iter(1, y, x)
  }
}
