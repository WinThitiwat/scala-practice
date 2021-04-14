package lectures.part2oop

object Inheritance extends App{
  /*
    class Foo {
      private def isFoo = true
      def doFoo(other: Foo) {
        if (other.isFoo) {  // this now compiles
          // ...
        }
      }
    }
  class Animal {
    protected def breathe {}
  }

  class Dog extends Animal {
    breathe
  }

   */


  // single class inheritance
   class Animal {
    val creatureType = "Wild"
    def eat = println("nomnom")

    // private - only allow to use in its class
    // protected - allow the method to be used in the subclass, but not outside class
    private def onlyInClassAnimal = true

    def isAnimal(animal: Animal) = {
      if(animal.onlyInClassAnimal){
        true
      }
      else false
    }



   }

  class Cat extends Animal {
    def crunch = {
      this.eat
      println("crunch crunch")
    }
  }

  val cat = new Cat

  cat.crunch // nomnom

  // constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // or Person(name)

  // overriding
  class Dog extends Animal {

    override val creatureType: String = "domestic"
    override def eat: Unit = println("crunch crunch")

  }

  // ways to override attribute given a input parameter
  class Dog2(override val creatureType : String) extends Animal { // passing in the constructor directly
    override def eat: Unit = {
      super.eat
      println(s"$creatureType crunch crunch")
    }
  }

  class Dog3(dogType: String) extends Animal { // pass the paramater to the attribute
    override val creatureType: String = dogType
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)


  // type substitution (broad : polymorphism)
  val unknownAnimal: Animal = new Dog2("K9")
  unknownAnimal.eat


  // overRIDING - supply a different implementation in derived classes
  // overLOADING - supply multiple methods with different signatures

  // super

  // preventing overrides
  // 1. put final keyword on member, i.e.  final def eat
  // 2. use final on the entire class, i.e. final class Animal -> class cannot extend Animal
  // 3. seal the class - possible to extend class in this file, but not other file , i.e. seal class Animal
}
