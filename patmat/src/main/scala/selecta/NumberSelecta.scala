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

  def product(xs: List[Int]): Int = xs match {
    case Nil => 1
    case head :: tail => head * product(tail)
  }
}