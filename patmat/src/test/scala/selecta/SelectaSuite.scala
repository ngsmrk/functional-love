package selecta

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SelectaSuite extends FunSuite {
  test("PositiveNumberSelecta removes negative numbers and zero") {
    assert(PositiveNumberSelecta(List(-1,2,-3,0)) === List(2))
  }

  test("Generic select removes negative numbers and zero") {
    val nums: List[Int] = List(-1, 2, -3, 0)
    val result = NumberSelecta.select(nums)((x: Int) => x > 0)
    assert(result === List(2))
  }

  test("Mergesort") {
    val nums = List(5,1,-9,0,2)
    val results = Sorta.msort(nums)((x: Int, y: Int) => x < y)
    assert(results === List(-9,0,1,2,5))
  }
}