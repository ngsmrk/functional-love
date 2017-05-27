package idealized

abstract class Nat {
  def isZero: scala.Boolean

  def predecessor: Nat

  def successor = new Succ(this)

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

class Succ(n: Nat) extends Nat {
  def isZero = false

  def predecessor = n

  def +(that: Nat): Nat = new Succ(n + that)

  def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor

  override def toString = "Predecessor " + n
}

object Zero extends Nat {
  def isZero = true

  def predecessor = throw new IllegalArgumentException("Zero has no predecessor")

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if (that.isZero) this else throw new IllegalArgumentException("Cannot subtract from zero")

  override def toString = "Zero"
}