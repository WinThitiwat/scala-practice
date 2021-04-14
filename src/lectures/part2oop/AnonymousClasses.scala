package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

//  anonymous class
  /*
   Another rule is to make sure that you provide implementations for
    all abstract fields or methods in the abstract types or traits that you
    instantiate anonymously, otherwise the compiler wouldn't be able to create
    a non-abstract class in the back for you
   */
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahaha")
  }

  /*
    ^^^
    equivalent to

    class AnonymousClass extends Animal {
     override def eat: Unit = println("hahahahaha")
    }

    val funnyAnimal: Animal = new AnonymousClass

   */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  // make sure to pass in proper parameters to the superclass
  // that you are extending even anonymously
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi im Jim")
  }

  /*
    So, anonymous class work for abstract (Animal) and non-abstract (Person) data type as well

    Takeaways:
    - We can instantiate types and override fields or methods on the spot

    trait Animal {
      def eat: Unit
    }
    val predator = new Animal {
      override def eat: Unit = println("RAWR")
    }

    Rules:
    - pass in required constructor arguments if needed
    - implement all abstract fields/methods

    Works for traits and classes whether they're abstract or not
   */
}
