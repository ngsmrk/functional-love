package conslists

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, MustMatchers}

/**
  * This class is a test suite for the methods in object FunSets. To run
  * the test suite, you can either:
  * - run the "test" command in the SBT console
  * - right-click the file in eclipse and chose "Run As" - "JUnit Test"
  */
@RunWith(classOf[JUnitRunner])
class ConsListSuite extends FunSpec with MustMatchers {

  describe("Cons") {

    def iterative_nth[T](n: Integer, list: List[T]): T = {
      if (n < 0) throw new IndexOutOfBoundsException("Index less than zero")

      // iterative, stateful version
      var elem = list
      for (i <- 1 to n) {
        if (!elem.isEmpty) elem = elem.tail
      }

      if (elem != null && !elem.isEmpty)
        elem.head
      else
        throw new IndexOutOfBoundsException("Index greater than list size");
    }

    def nth[T](n: Integer, list: List[T]): T = {
      if (n < 0) throw new IndexOutOfBoundsException("Index less than zero")
      else if (list isEmpty) throw new IndexOutOfBoundsException("Index greater than list size")
      else if (n == 0) list.head
      else nth(n -1, list.tail)
    }

    val list_1 = new Cons[Int](4, new Nil[Int])

    describe("isEmpty") {
      it("is always false") {
        assert(!list_1.isEmpty)
      }
    }

    describe("head") {
      it("returns the correct value") {
        assert(list_1.head === 4)
      }
    }

    describe("tail") {
      it("returns the correct value") {
        assert(list_1.tail.isInstanceOf[Nil[Int]])
      }
    }

    describe("iterative_nth") {
      it("throws an IndexOutOfBoundsException if index is less than zero") {
        val ex = intercept[IndexOutOfBoundsException] {
          iterative_nth(-1, list_1)
        }

        assert((ex getMessage()) === "Index less than zero")
      }

      it("throws an IndexOutOfBoundsException if index is greater than list size") {
        val ex = intercept[IndexOutOfBoundsException] {
          iterative_nth(10, list_1)
        }

        assert((ex getMessage()) === "Index greater than list size")
      }

      it("returns correct value based on index") {
        val list_2 = new Cons[Int](4, new Cons[Int](5, new Nil[Int]))
        assert(iterative_nth(1, list_2) === 5)
      }
    }

    describe("nth") {
      it("throws an IndexOutOfBoundsException if index is less than zero") {
        val ex = intercept[IndexOutOfBoundsException] {
          nth(-1, list_1)
        }

        assert((ex getMessage()) === "Index less than zero")
      }

      it("throws an IndexOutOfBoundsException if index is greater than list size") {
        val ex = intercept[IndexOutOfBoundsException] {
          nth(10, list_1)
        }

        assert((ex getMessage()) === "Index greater than list size")
      }

      it("returns correct value based on index") {
        val list_2 = new Cons[Int](4, new Cons[Int](5, new Nil[Int]))
        assert(nth(1, list_2) === 5)
      }
    }

  }
}
