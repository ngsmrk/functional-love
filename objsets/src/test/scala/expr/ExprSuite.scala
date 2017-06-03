package expr

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExprSuite extends FunSuite {
  test("Sum") {
    assert(Sum(Number(1), Number(2)).eval === 3)
  }

  test("Product") {
    assert(Product(Number(1), Number(2)).eval === 2)
  }

  test("Show") {
    assert(Product(Number(1), Number(2)).show === "1 * 2")
  }

  test("Advanced Show") {
    assert(Sum(Product(Number(1), Number(2)), new Number(4)).show === "1 * 2 + 4")
  }
}
