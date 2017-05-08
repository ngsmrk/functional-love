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
    def iterAdd(y:Int, acc: Int): Int = {
      if (y==0) acc
      else iterAdd(y-1, acc+1)
    }

    iterAdd(y, x)
  }
}
