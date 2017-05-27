package idealized

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IdealizedSuite extends FunSuite {

  test("&&") {
    assert((idealized.True && idealized.True).isTrue)
    assert(!(idealized.True && idealized.False).isTrue)
    assert(!(idealized.False && idealized.True).isTrue)
    assert(!(idealized.False && idealized.False).isTrue)
  }

  test("<") {
    assert((idealized.False < idealized.True).isTrue)
    assert(!(idealized.True < idealized.False).isTrue)
  }

  test("+") {
    val result: Int = new Int(3) + new Int(5)
    assert(result.x == 8)
  }

  test("Zero +") {
    assert(Zero + Zero == Zero)
    assert((Zero + new Succ(Zero)).predecessor == new Succ(Zero).predecessor)
  }

  test("Zero -") {
    val thrown = intercept[IllegalArgumentException] {
      Zero - new Succ(Zero)
    }

    assert(thrown.getMessage === "Cannot subtract from zero")

    assert(Zero - Zero == Zero)
  }

  test("Succ +") {
    assert((new Succ(Zero) + Zero).predecessor === new Succ(Zero).predecessor)

    // val result: Nat = new Succ(Zero) + new Succ(Zero)
    // val expected: Succ = new Succ(new Succ(Zero))
    // assert(result == expected)
  }

  test("Succ -") {
    assert((new Succ(Zero) - Zero).predecessor === new Succ(Zero).predecessor)

    // val result: Nat = new Succ(Zero) - new Succ(Zero)
    // val expected: Nat = Zero
    // assert(result == expected)
  }

  test("Zero =") {
    assert(Zero === Zero)
    assert(Zero != new Succ(Zero))
  }

  test("Succ =") {
    assert(new Succ(Zero) === new Succ(Zero))
  }
}
