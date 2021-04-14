package lectures.part2oop

object MethodNotations extends App{

  class Person(val name: String, val favorite_movie: String, val age:Int = 0){
    def likes(movie:String): Boolean = {
      movie == favorite_movie
    }

    def hangoutWith(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    def +(person: Person): String = s"${this.name} is adding ${person.name}"

    def +(new_name:String): Person = new Person(s"$name ($new_name)", s"$favorite_movie")

    def unary_! : String = s"${this.name}! What the heck "

    def unary_+ : Person = new Person(name, favorite_movie, age+1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favorite_movie"

    def apply(times: Int = 0): String = s"$name watched $favorite_movie $times times"

    def learns(thing: String): String = s"$name is learning $thing"

    def learnsScala() = this learns "Scala"
  }


  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent to above
  // infix notation = operator notation (syntactic sugar)
  // only work with a single parameter method

  val tom = new Person("Tom", "Fight Club")
  println(mary hangoutWith tom)

//  println(mary + tom)
//  println(mary.+(tom))

  //ALL OPERATORS ARE METHODS


  // prefix notation : unary operator
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-

  // unary_ prefix only works with + - ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation: only work with method without parameter
  println(mary.isAlive)

  println(mary isAlive)

  // apply
  println(mary.apply(2))
  println(mary()) // equivalent to mary.apply()

  println((mary + "the rock star").apply())

  println((+mary).age)

  println(mary learnsScala())
}

/*
  overload the + operator: mary + "the rockstart" => new Person "Mary (the rockstar)"

  Add an age to the Person class, and add a unary + operator => new Person with the age + 1
    i.e. +mary => mary with the age incrementer

  Add a "learns" method in the Person class (thing) => "Mary learns thing"

  Add a learnScala method by calling learns method with "Scala" (use it in postfix notation)

  overload the apply method => mary.apply(2) = "Mary watched Inception 2 times


 */




