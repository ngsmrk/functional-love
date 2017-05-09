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
    def iterAdd(increment: Int, y:Int, acc: Int): Int = {
      if (y==0) acc
      else iterAdd(increment, y-1, acc+1)
    }

    iterAdd(1, y, x)
  }
}
