abstract class TreeElement {
  def isEmpty: Boolean

  def add(other: Int): TreeElement
}

object Empty extends TreeElement {
  def isEmpty = true

  override def toString = "."

  def add(other: Int) = new Element(Empty, other, Empty)
}

class Element(val left: TreeElement, val value: Int, val right: TreeElement) extends TreeElement {
  def isEmpty = false

  override def toString = "{" + left + value + right + "}"

  def add(other: Int) = {
    if (other < value) new Element(left.add(other), value, right)
    else if (other > value) new Element(left, value, right.add(other))
    else this
  }
}

println(Empty)
println(new Element(Empty, 1, Empty).add(2))