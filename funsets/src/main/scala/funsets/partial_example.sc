object partial_adder {

  def adder(m: Int, n: Int) = m + n

  def add2(m: Int) = adder(2, m)

  add2(2)

  // same as above but the signature is inferred
  val partial_add_2 = adder(2, _: Int)
  partial_add_2(2)
}