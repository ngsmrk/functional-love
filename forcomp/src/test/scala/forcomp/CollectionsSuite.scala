package forcomp

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CollectionsSuite extends FunSuite {

  trait TestData {
    val oddNums = List(1, 3)
    val evenNums = List(2, 4)
  }

  new TestData {
    def modulo = (x: Int) => x % 2 == 0

    test("exists returns true if at least 1 element matches") {
      assert(evenNums exists modulo)
    }

    test("exists returns false if no element matches") {
      assert((oddNums exists modulo) === false)
    }

    test("forall returns true if all elements match") {
      assert(oddNums forall ((x: Int) => x > 0))
    }

    test("forall returns false if 1 element doesn't match") {
      assert((oddNums forall ((x: Int) => x < 0)) === false)
    }

    test("zip combines lists into pairs") {
      assert((oddNums zip evenNums) === List((1, 2), (3, 4)))
    }

    test("zip discards additional elements of right list") {
      assert((List(1) zip evenNums) === List((1, 2)))
    }

    test("zip discards additional elements of left list") {
      assert((List(1, 1) zip List(2)) === List((1, 2)))
    }

    test("unzip splits pairs into 2 sequences") {
      val (seqA, seqB) = List((3, 6), (2, 4)).unzip
      assert(seqA === List(3, 2))
    }

    test("unzip3 splits tuples into 3 sequences") {
      val (seqA, seqB, seqC) = List((3, 6, 9), (2, 4, 6)).unzip3
      assert(seqA === List(3, 2))
    }

    test("flatMap") {
      val result = (2 to 10 by 2) flatMap (x => (1 to 5 by 1) map (y => (x, y)))
      assert(result.size === 25)
      assert(result(0) ===(2, 1))
      assert(result.last ===(10, 5))
    }

    test("flatMap with primes") {
      def isPrime(n: Int) = (2 until n) forall (n % _ != 0)

      val numbers = (1 until 5) flatMap (i => (1 until i) map (j => (i, j)))

      val primes = numbers filter (pair => isPrime(pair._1 + pair._2))

      assert(Vector((2, 1), (3, 2), (4, 1), (4, 3)) === primes)
    }

    test("filter") {
      val x = List(1, 2, 3, 4)
      def isEven = (elem: Int) => elem % 2 == 0
      assert(List(2, 4) === x.filter(isEven))
      assert(List(1, 3) === x.filterNot(isEven))
    }

    test("filter with pairs") {
      val x = List(('a', 1), ('b', 1), ('c', 1), ('d', 2))
      def twoOccurrences = (pair: (Char, Int)) => pair._2 == 2
      assert(List(('d', 2)) === x.filter(twoOccurrences))
    }

    test("collect") {
      val results = List(1, 2, 3, 4, "5") collect {
        // can handle mixed types
        case i: Int => i.toString
        case s: String => s
      }

      assert(List("1", "2", "3", "4", "5") === results)
    }

    test("take") {
      assert(List(1, 2) === List(1, 2, 3, 4).take(2))
    }

    test("takeWhile") {
      assert(List(1, 2) === List(1, 2, 3, 4).takeWhile((x: Int) => x == 1 || x == 2))
    }

    test("drop") {
      assert(List(3, 4) === List(1, 2, 3, 4).drop(2))
    }

    test("dropWhile") {
      assert(List(3, 4) === List(1, 2, 3, 4).dropWhile((x: Int) => x == 1 || x == 2))
    }

    test("zipAll") {
      val a = List("a", "b", "c", "d")
      val b = List(1, 2, 3)

      assert(List(("a", 1), ("b", 2), ("c", 3), ("d", 100)) === a.zipAll(b, "for missing values", 100))
    }

    test("map") {
      assert(List(2, 4) === List(1, 2).map((x: Int) => {
        x * 2
      }))
    }

    test("foldLeft") {
      assert(3 === List(1, 2).foldLeft(0)((acc: Int, x: Int) => {
        acc + x
      })) // 0 + 1 + 2 - equivalent to .sum
      assert("abc" === List('a', 'b', 'c').foldLeft("")((acc: String, x: Char) => {
        acc + x
      }))
    }

    test("foldRight") {
      assert(3 === List(1, 2).foldRight(0)((acc: Int, x: Int) => {
        acc + x
      })) // 0 + 2 + 1 - equivalent to .sum
      assert("cba" === List('a', 'b', 'c').foldRight("")((x: Char, acc: String) => {
        acc + x
      }))
    }

    test("for") {
      val result = for (x <- List(1, 2, 3, 4)) yield x * 2
      assert(List(2, 4, 6, 8) === result)
    }

    test("forEach") {
      val result = List(2, 4).foreach((x: Int) => println(x * x)) // side effects are discarded (returns Unit)
      assert(() === result)
    }
  }
}