import scala.annotation.tailrec

object for_all {
  val bound = 1000

  // imperative version
  def checkall(p: Int => Boolean): Boolean = {
    for (i <- -bound to bound) {
      if (!p(i)) return false
    }
    true
  }

  checkall({ x: Int => println(x); x % 2 == 0 })

  // functional version
  def forall(p: Int => Boolean): Boolean = {

    @tailrec
    def inforall(x: Int): Boolean = {
      if (x > bound) true
      else if (!p(x)) false
      else inforall(x + 1)
    }

    inforall(-bound)
  }

  forall({ x: Int => println(x); x % 2 == 0 })
}