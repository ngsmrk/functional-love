package math

/**
  * . 
  *
  * @author Initial: amark
  * @version 1.0
  */
class IterativeAdder extends Adder {

  override def add(x: Int, y: Int): Int = {

    var acc = x

    for (i <- 0 until y) {
      acc += 1
    }

    acc
  }
}
