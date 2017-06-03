package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
	}

  test("weight of single leaf tree") {
    val weight_1 = weight(Leaf('a', 3))
    assert(weight_1 === 3)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of single leaf tree") {
    val chars_1 = chars(Leaf('a', 3))
    assert(chars_1 === List('a'))
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("show single leaf tree") {
    val str = stringify(Leaf('a', 3))
    assert(str === "a:3")
  }

  test("show a larger tree") {
    new TestTrees {
      assert(stringify(t1) === "a:2 b:3")
    }
  }

  test("show an even larger tree") {
    new TestTrees {
      assert(stringify(t2) === "a:2 b:3 d:4")
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("make simple code tree") {
    val codeTree = makeCodeTree(Leaf('x', 1), Leaf('e', 1))
    assert(chars(codeTree) === List('x', 'e'))
  }

  test("make more complex code tree") {
    val sampleTree = makeCodeTree(
      makeCodeTree(Leaf('x', 1), Leaf('e', 1)),
      Leaf('t', 2)
    )
    println(stringify(sampleTree))
    assert(chars(sampleTree) === List('x', 'e', 't'))
  }

  test("times") {
    val result = times(List('a', 'b', 'a'))
    assert(result === List(('a', 2), ('b', 1)))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }


  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }


  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

}
