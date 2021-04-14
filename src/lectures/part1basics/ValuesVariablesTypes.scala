package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x:Int = 42

  println(x)

  // `val` type is immutable
  // compiler can infer types

  val aString:String = "Hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = true // or false
  val aCharacter: Char = 'a' // single quote represent a character
  val anInt: Int = x
  val aShort: Short = 10000 // 4 bytes or 16 bits -> largest Short int = (2^16)/2 and smallest Short int = -(2^16)/2
  val aLong: Long = 12356666645L // 8 bytes to mark as long number, put L at the end
  val aFloat: Float = 1.23f // required `f`
  val aDouble: Double = 3.14 // no postfix required

  // Variables
  var aVariable: Int = 4
  aVariable = 5 // side effect


}
