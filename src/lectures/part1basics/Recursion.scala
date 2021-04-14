package lectures.part1basics

import java.util.concurrent.atomic.DoubleAccumulator

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))

      val result = n * factorial(n - 1)

      println("Computed factorial of " + n)

      result
    }

  def anotherFactorial(n: Int): Int = {
    def factHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1)
        accumulator
      else
        factHelper(x - 1, x * accumulator) // Tail Recursion: use recursive call as the LAST expression
    }

    factHelper(n, 1)
  }


  // WHEN NEED LOOPS, USE _TAIL_RECURSION

  /*

  1. Concatenate a string n times
  2. isPrime function tail recursive
  3. Fibonacci function, tail recursive
 */

  @tailrec
  def stringConcat(str: String, strAccumulator: String, n: Int): String = {
    if (n <= 0)
      strAccumulator
    else
      stringConcat(str, strAccumulator + str, n - 1)
  }

  println(stringConcat("Test", "", 4))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) // check an intermediate result
        false
      else if (t <= 1)
        true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

    }

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {

    @tailrec
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n)
        last
      else
        fibonacciTailRec(i + 1, last + nextToLast, last)
    }

    if (n <= 2)
      1
    else
      fibonacciTailRec(2, 1, 1)
  }

  println(fibonacci(8))

}
