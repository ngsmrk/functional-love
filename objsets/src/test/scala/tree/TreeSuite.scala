package tree

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TreeSuite extends FunSuite {
  test("Add") {
    val result = Element(1).add(2)

    result match {
      case e: Element => {
        assert(e.left.isEmpty)
        assert(e.right.asInstanceOf[Element].value === 2)
        assert(e.value === 1)
      }
      case _ => throw new Error("Unexpected type")
    }
  }

  test("findMin with one element") {
    val element = Element(1)
    assert(element.findMin === 1)
  }

  test("findMin") {
    val element = Element(3).add(1).add(5)
    assert(element.findMin === 1)
  }

  test("findMax with one element") {
    val element = Element(1)
    assert(element.findMax === 1)
  }

  test("findMax") {
    val element = Element(3).add(1).add(5)
    println(element)
    assert(element.findMax === 5)
  }
}