package intsets

object Empty extends IntSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = {
    new NonEmpty(x, Empty, Empty)
  }

  def union(other: IntSet): IntSet = { println("Union " + other + " and " + this); other }

  override def toString = {
    "."
  }
}
