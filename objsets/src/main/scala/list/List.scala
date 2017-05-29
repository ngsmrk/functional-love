package list

trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true

  def head = throw new NoSuchElementException("Nil.head")

  def tail = throw new NoSuchElementException("Nil.tail")
}

object List {
  def apply[T](x1: T): List[T] = {
    new Cons[T](x1, apply())
  }

  def apply[T](x1: T, x2: T): List[T] = {
    new Cons(x1, apply(x2))
  }

  def apply[T](): List[T] = {
    new Nil
  }
}