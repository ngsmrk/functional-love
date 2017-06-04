package selecta

object NumberSelecta {
  def select[T](xs: List[T])(lt: (T) => Boolean): List[T] = (xs) match {
    case (Nil) => xs
    case (xs_head :: xs_tail) => {
      if (lt(xs_head)) xs_head :: select(xs_tail)(lt) else select(xs_tail)(lt)
    }
  }
}