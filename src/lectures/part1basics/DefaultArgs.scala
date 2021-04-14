package lectures.part1basics

object DefaultArgs extends App {
  def trFact(n: Int, acc: Int = 1): Int = {
    if ( n <= 1) 1
    else trFact(n-1, n * acc)
  }



}
