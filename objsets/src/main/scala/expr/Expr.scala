package expr

trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Product(e1, e2) => e1.eval * e2.eval
  }

  def show: String = this match {
    case Number(n) => toString(n)
    case Sum(e1, e2) => e1.show + " + " + e2.show
    case Product(e1, e2) => e1.show + " * " + e2.show
  }

  def toString(n: Int): String = {
    n.toString
  }
}

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Product(e1: Expr, e2: Expr) extends Expr