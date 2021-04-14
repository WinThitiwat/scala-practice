package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("Crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "Fresh meat"
  }

  trait ColdBlooded

  class Snake extends Carnivore with ColdBlooded {
    def eat(animal:Animal): Unit = println(s"I'm snake eating ${animal.creatureType}")
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType : String = "Croc"
    override def eat: Unit = println("nomnom")
    def eat(animal: Animal): Unit = println("I'm a croc and I'm eating ${animal.creatureType}")
  }

  // traits vs abstract classes
  // 1 - traits do not have constructor paramters
  // 2 - multiple traits may by inherited by the same class (a way to implement multiple inheritance)
  // 3 - traits = behavior (what they do), abstract = "object, thing"


}
