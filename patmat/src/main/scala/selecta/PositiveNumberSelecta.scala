package selecta

object PositiveNumberSelecta {

  def apply(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case head :: tail => if (head > 0) head :: apply(tail) else apply(tail)
  }
}