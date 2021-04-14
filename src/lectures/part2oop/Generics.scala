package lectures.part2oop

object Generics extends App{
  class MyList[A] {
    // use the type A
  }



  trait MyTrait[A]

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList { // object cannot be type parameterized
    def empty[A]: MyList[A] = ???

  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // A question is - If Cat extends Animal, then does a list of Cat also extend the list of Animal
  // 1. Yes - List of Cat extends List of Animal = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animal
  class MyList2[+A]{

    def add[B >: A] (element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal

     */
  }

  // 2. No - Invariance - every type is its own type or own world
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no = CONTRAVARIANCE: opposite relation to Covariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
  // the semantic will change to that I can a trainer of Cat, but I supply a trainer of Animal where it can train any Animal


  // Bounder types - only allow to use your generic classes only for certain types that are either a subclass of a different
  // type of a superclass of a different type

  // class [A <: Type] - the class only accept type parameter that is a subtype of Animal
  // class [A >: Type] - the class only accept type parameter that is a supertype of Animal

  class Cage[A <: Animal](animal: A) // class Cage only accepts type parameter A, which are subtypes(<:) of Animal

  val cage = new Cage(new Dog) // works bec Dog is subclass Animal

  class Car
  //   |||  generic type needs proper bounded type
  //   vvv
//  val newCage = new Cage(new Car) // fail bec Car is not subclass of Animal


  // expand MyList to be generic in -> MyGenericList.sc

}
