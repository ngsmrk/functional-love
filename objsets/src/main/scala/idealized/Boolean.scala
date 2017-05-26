package idealized

/**
  * . 
  *
  * @author Initial: amark
  * @version 1.0
  */
abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: Boolean): Boolean = ifThenElse[Boolean](x, False)
  def || (x: Boolean): Boolean = ifThenElse[Boolean](True, x)
  def unary_! : Boolean = ifThenElse[Boolean](False, True)

  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
  def != (x: Boolean): Boolean = ifThenElse(x.unary_!, x)

  def isTrue: scala.Boolean

  // false < true
  def < (x: Boolean): Boolean = ifThenElse(False, x)
}

object True extends Boolean {
 def ifThenElse[T](t: => T, e: => T): T = t

  override def isTrue: scala.Boolean = true
}

object False extends Boolean {
 def ifThenElse[T](t: => T, e: => T): T = e

  override def isTrue: scala.Boolean = false
}
