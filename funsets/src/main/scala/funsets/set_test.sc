object set_test {
  // simple application of InSet using an applied function
  def contains(f: (Int, Int) => Boolean)(expected: Int, actual: Int): Boolean = {
    f(expected, actual)
  }

  def inSet(x: Int, y: Int) = {
    x == y
  }

  contains(inSet)(1, 1)
  contains(inSet)(1, 2)

  val inSet_1 = inSet(1, _: Int)
  inSet_1(3)

  def contains_2(f: (Int) => Boolean)(actual: Int): Boolean = {
    f(actual)
  }

  contains_2(inSet_1)(1)

  // using functions
  def either(f1: (Int) => Boolean, f2: (Int) => Boolean)(x: Int): Boolean = {
    f1(x) || f2(x)
  }

  either(x => { println("1st function - x = " + x); x == 1 } , x => { println("2nd function - x = " + x); x == 2 } )(1)
  either(x => { println("1st function - x = " + x); x == 1 } , x => { println("2nd function - x = " + x); x == 2 } )(2)
  either(x => { println("1st function - x = " + x); x == 1 } , x => { println("2nd function - x = " + x); x == 2 } )(3)

  // without functions
  def either_without_functions(x: Int): Boolean = {

    def check(a: Int, b:Int): Boolean = {
      x == a || x ==b
    }

    check(1, 2)
  }

  either_without_functions(1)

  // using functions
  def and(f1: (Int) => Boolean, f2: (Int) => Boolean)(x: Int): Boolean = {
    f1(x) && f2(x)
  }

  and(x => { println("1st function - x = " + x); x % 2 == 0 } , x => { println("2nd function - x = " + x); x == 2 } )(2)
}