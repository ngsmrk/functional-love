package intsets

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def union(other: IntSet): IntSet = {
    val newLeft: IntSet = left union right
    println("New left " + newLeft)
    val newSet: IntSet = newLeft union other
    println("New set " + newSet)
    newSet incl elem
  }

  override def toString = {
    "{ left " + left + " elem = " + elem + " right = " + right + "}"
  }
}