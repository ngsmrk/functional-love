package funsets.math

import math.{RecursiveAdder, IterativeAdder}
import org.scalatest.FunSpec

class AdderSpec extends FunSpec {

  describe("IterativeAdder") {

    it("can add positive numbers together") {
      val adder = new IterativeAdder
      assert(adder.add(8, 2) === 10)
    }
  }

  describe("RecursiveAdder") {

    it("can add positive numbers together") {
      val adder = new RecursiveAdder
      assert(adder.add(8, 2) === 10)
    }
  }
}