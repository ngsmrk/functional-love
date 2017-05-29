package tree

abstract class TreeElement {
  def isEmpty: Boolean

  def add(other: Int): TreeElement

  def findMin: Int

  def findMax: Int
}

object Empty extends TreeElement {
  def isEmpty = true

  override def toString = "."

  def add(other: Int) = new Element(Empty, other, Empty)

  def findMin = throw new Error("Empty.min")
  def findMax = throw new Error("Empty.max")
}

class Element(val left: TreeElement, val value: Int, val right: TreeElement) extends TreeElement {
  def isEmpty = false

  override def toString = "{" + left + value + right + "}"

  def add(other: Int) = {
    if (other < value) new Element(left.add(other), value, right)
    else if (other > value) new Element(left, value, right.add(other))
    else this
  }

  def findMin = {
    if (left.isEmpty) this.value else left.findMin
  }

  def findMax = {
    if (right.isEmpty) this.value else right.findMax
  }
}

object Element {
  def apply(x: Int): TreeElement = {
    new Element(Empty, x, Empty)
  }
}