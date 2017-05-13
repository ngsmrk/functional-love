package intsets

import org.junit.runner.RunWith
import org.scalatest.{MustMatchers, FunSuite}
import org.scalatest.junit.JUnitRunner

/**
  * This class is a test suite for the methods in object FunSets. To run
  * the test suite, you can either:
  * - run the "test" command in the SBT console
  * - right-click the file in eclipse and chose "Run As" - "JUnit Test"
  */
@RunWith(classOf[JUnitRunner])
class IntSetSuite extends FunSuite with MustMatchers {

  val t1 = new NonEmpty(3, Empty, Empty)

  test("contains is implemented") {
    assert(t1 contains 3)
    assert(!(t1 contains 2))
    assert(!(t1 contains 4))
  }

  test("incl is implemented") {
    val t2 = t1 incl 2 incl 4
    assert(t2 contains 2)
    assert(t2 contains 4)
    t2 contains 4 must be (true)
  }

  test("toString is implemented for Empty") {
    assert(Empty.toString === ".")
  }

  test("toString is implemented for NonEmpty") {
    assert(t1.toString === "{ left . elem = 3 right = .}")
  }

  test("Union is implemented for Empty") {
    val union = Empty union t1
    assert(union === t1)
  }

  test("Union is implemented for NonEmpty") {
    val t2 = new NonEmpty(4, Empty, Empty)
    val union = t2 union t1

    assert(union.toString === "{ left . elem = 3 right = { left . elem = 4 right = .}}")
  }
}
