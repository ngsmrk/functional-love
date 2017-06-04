package selecta

object Sorta {

  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {

      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (xs_head :: xs_tail, ys_head :: ys_tail) => {
          if (lt(xs_head, ys_head)) xs_head :: merge(xs_tail, ys)
          else ys_head :: merge(xs, ys_tail)
        }
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }
}
