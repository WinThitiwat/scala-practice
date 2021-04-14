package lectures.part2oop

object Objects extends App{

  // Scala does not have class-level functionality, that means it has no static attribute


  // Scala object = Singleton object
  object Person { // type + its only instance
    // "static" / "class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method - its purpose is to build person given some parameter
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance - level functionality

  }


  val person1 = Person
  val person2 = Person
  println(person1 == person2) // true as it's singleton

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // false as they are not pointing to the same object

  val bobbie = Person.apply(mary, john) // or Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
  // if no def main, then `object MyApp extends App`


}
