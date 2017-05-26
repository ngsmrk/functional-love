package idealized

class Int(val x: scala.Int) {
  def + (other: Int) = {
    new Int(this.x + other.x)
  }
}