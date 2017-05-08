import scala.annotation.tailrec

object rationals {

  class Rational(x: Int, y: Int) {

    @tailrec
    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    def numer = x
    def denom = y

    def neg = {
      new Rational(-numer, denom)
    }

    def add(other: Rational): Rational = {
      // new Rational(numer * other.denom + other.numer * denom, denom * other.denom)
      calculate((x: Int, y: Int) => x + y)(this, other)
    }

    def sub(other: Rational): Rational = {
      // new Rational(numer * other.denom - other.numer * denom, denom * other.denom)
      calculate((x: Int, y: Int) => x - y)(this, other)
    }

    def calculate(f: (Int, Int) => Int)(r1: Rational, r2: Rational) = {
      new Rational(f(numer * r2.denom, r2.numer * denom), denom * r2.denom)
    }

    override def toString = {
      val g: Int = gcd(numer, denom)
      numer / g + "/" + denom / g
    }
  }
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x neg

  x add y

  x sub y sub z

  y add y

  y sub y
}