package recfun

import scala.annotation.tailrec
import scala.collection.mutable

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    val leftBrackets = new mutable.Stack[Char]
    var valid = true

    @tailrec
    def balanceIter(charsToCheck: List[Char]): Unit = {
      if (charsToCheck nonEmpty) {
        val nextChar = charsToCheck.head
        if (nextChar equals '(') {
          leftBrackets push nextChar
          balanceIter(charsToCheck tail)
        } else if (nextChar equals ')') {
          if (leftBrackets nonEmpty) {
            leftBrackets.pop
            balanceIter(charsToCheck tail)
          } else {
            valid = false
          }

        } else {
          balanceIter(charsToCheck tail)
        }
      }
    }

    balanceIter(chars)
    leftBrackets.isEmpty && valid
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {

    def changeCount(money: Int, coins: List[Int], count: Int, level: Int): Int = {
      if (money == 0) { printf("Money is 0: %d %s %d", money, coins, level);println(); count + 1 }
      else if (money < 0 || (coins isEmpty)) { printf("Money is < 0 or no coins left: %d %s %d", money, coins, level);println(); count }
      else changeCount(money - coins.head, coins, count, level + 1) + changeCount(money, coins.tail, count, level + 1)
    }

    if (money < 0 || (coins isEmpty)) 0 else changeCount(money, coins, 0, 0)
  }
}
