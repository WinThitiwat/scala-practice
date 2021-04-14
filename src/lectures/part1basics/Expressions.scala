package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // 1+ 2 is an expression
  println(x)

  println(2 + 3 * 4)
  // math operation: + - * / & ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  //  ==, !=, >, >=, <, <=

  println(!(1==x))
  //  logical negation: ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -=  *=  /=

  println(aVariable)

  // Instructions vs Expressions
  // Instruction (tell what to DO)
  // Expressions (assign value)

  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF expression, NOT if instruction
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)


  var i = 0
  while(i < 10) {
    println(i)
  }
//  NEVER WRITE THIS AS ITS NOT EXPRESSIONS
//  REMEMBER: Everything in Scala is an Expression

  var aWeirdValue = (aVariable = 3) // Unit === void
  print(aWeirdValue) // result => ()

  // side effects : println(), whiles, reassigning

  // code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2 ) "hello"
    else "python"
  }

//  val anotherValue = z + 1 // Error: z only works in its code block

  println

}
