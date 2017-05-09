package funsets.math

import math.{RecursiveMultiplier, IterativeMultiplier}
import org.scalatest.FunSpec

class MultiplierSpec extends FunSpec {

  describe("IterativeMultiplier") {

    it("can add positive numbers together") {
      val adder = new IterativeMultiplier
      assert(adder.multiply(8, 2) === 16)
    }
  }

  describe("RecursiveMultiplier") {

    it("can add positive numbers together") {
      val adder = new RecursiveMultiplier
      assert(adder.multiply(8, 2) === 16)
    }
  }
}
