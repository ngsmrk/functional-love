package math

/**
  * . 
  *
  * @author Initial: amark
  * @version 1.0
  */
class IterativeMultiplier extends Multiplier {
  override def multiply(x: Int, y: Int) = {

    var accumulator = 0

    for (i <- 0 until y)
      accumulator += x

    accumulator
  }
}
