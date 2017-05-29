package list

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListSuite extends FunSuite {
  test("List construction") {
    val result: List[Int] = List(1, 2)

    assert(result.head === 1)
    assert(result.tail.head === 2)
    assert(result.tail.tail.isEmpty)

    assert(List().isEmpty)
  }
}