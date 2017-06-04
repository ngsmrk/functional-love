package selecta

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PositiveNumberSelectaSuite extends FunSuite {
  test("Select removes negative numbers and zero") {
    assert(PositiveNumberSelecta(List(-1,2,-3,0)) === List(2))
  }
}