package selecta

object NumberSelecta {
  def select[T](xs: List[T])(lt: (T) => Boolean): List[T] = (xs) match {
    case (Nil) => xs
    case (xs_head :: xs_tail) => {
      if (lt(xs_head)) xs_head :: select(xs_tail)(lt) else select(xs_tail)(lt)
    }
  }

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case head :: tail => {
      val (first, rest) = xs span (elem => elem == head)
      first :: pack(rest)
    }
  }

  def encode[T](xs: List[T]): List[(T, Int)] = {
    val packed = pack(xs)

    packed map (ys => (ys.head, ys.length))
  }

  def sum(xs: List[Int]): Int = xs match {
    case Nil => 0
    case head :: tail => head + sum(tail)
  }

  def sumWithReduce(xs: List[Int]): Int = (0 :: xs) reduceLeft((x, y) => x + y)
  def productWithReduce(xs: List[Int]): Int = (1 :: xs) reduceLeft((x, y) => x * y)

  def sumWithFold(xs: List[Int]): Int = {
    (xs foldLeft 0) ((x, y) => x + y)
  }

  def productWithFold(xs: List[Int]): Int = {
    (xs foldLeft 1) ((x, y) => x * y)
  }

  def product(xs: List[Int]): Int = xs match {
    case Nil => 1
    case head :: tail => head * product(tail)
  }
}