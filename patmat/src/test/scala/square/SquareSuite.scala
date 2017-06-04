package square

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SquareSuite extends FunSuite {
  test("Square") {
    assert(SquareList(Nil) === Nil)
    assert(SquareList(List()) === List())
    assert(SquareList(List(1,2,3)) === List(1,4,9))
  }

  test("Native Square using Map") {
    assert(SquareListWithMap(Nil) === Nil)
    assert(SquareListWithMap(List()) === List())
    assert(SquareListWithMap(List(1,2,3)) === List(1,4,9))
  }
}