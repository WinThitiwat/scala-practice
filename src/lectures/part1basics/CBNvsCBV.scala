package lectures.part1basics

object CBNvsCBV extends App{
  def calledByValue(x: Long): Unit = {
    println("by Value: " + x)
    println("by Value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by Name: " + x)
    println("by Name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

//  The difference
  //  calledByValue
  //      - value is computed before the function is called
//        - same value used everywhere
//    calledByName
//        - expression is passed literally
//        - expression is evaluated at every use within the called function


//  def calledByValue(x: Long): Unit = {
//    println("by Value: " + 367632244410794)
//    println("by Value: " + 367632244410794)
//  }
//
//  def calledByName(x: => Long): Unit = {
//    println("by Name: " + System.nanoTime())  => 367632374294936
//    println("by Name: " + System.nanoTime())  => 367632374340830
//  }




}
