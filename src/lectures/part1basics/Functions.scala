package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b : Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction) // compiler will understand that this is parameterless and runnable function

  def aRepeatedFunction(aString: String, n: Int): String ={
    if (n == 1)
      aString
    else
      aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Hello", 3))

  // ^^^ When loops are needed, use recursion ^^^

  def aFunctionWithSideEffects(aString: String):Unit = println(aString)

  def aBigFunction(n: Int):Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)

  }

  // Exercise 1: A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  def aGreetingFunction(name: String, age: Int):String =
    "Hi, my name is " + name + " and I am " + age + " years old"

  println(aGreetingFunction("David", 14))

  // Exercise 2: Factorial function 1 * 2 * 3 * ... * n
  def aFactorial(n: Int): Int = {
    if (n <= 0) 1
    else n * aFactorial(n-1)
  }

  println(aFactorial(5))


  // Exercise 3: A Fibonacci function
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n - 2)
  }



  // Exercise 4: Check if a number is prime
  def isPrime(n : Int): Boolean = {
    def isPrimeUntil(t: Int):Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }


}




