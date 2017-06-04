package square

object SquareList {
  def apply(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil // matches Nil and Empty
    case y :: ys => (y * y) :: apply(ys)
  }
}

object SquareListWithMap {
  def apply(xs: List[Int]): List[Int] = xs map (x => x * x)
}