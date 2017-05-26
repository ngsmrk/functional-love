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
}
