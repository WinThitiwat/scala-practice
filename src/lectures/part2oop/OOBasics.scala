package lectures.part2oop

object OOBasics extends App{

  val person = new Person("John", 26)
  person.greet("Daniel")

  val writer = new Writer("Tom", "Johnny", 1812)
  val novel = new Novel("Great Expectations", 1861, writer)
  println(novel.getAuthorAge())


  val counter = new Counter()
  counter.inc.print()

  counter.inc.inc.inc.print()

  counter.inc(10).print()
}

class Person(name: String, val age: Int = 0) {  // primary constructor

  // multiple constructor as a auxiliary constructor
  def this(name: String) = this(name, 0) // calls the primary constructor

  def this() = this("John Doe")

  // class parameters are NOT FIELDS
  // putting val in the parameter allows a field call like person.age

  // body
  val x = 2 // x is a field when declared with val


  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

}


/*

  Novel and a Writer

  Writer: first name, surname, year
  - method get_fullname()

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy ( new year of release) = new instance of Novel

 */

class Writer(first_name: String, surname: String, val year: Int) {

  def getFullName():String = {
    s"${this.first_name} ${this.surname}"
  }

}

class Novel(name:String, year_released:Int, author: Writer) {

  def getAuthorAge():Int = year_released - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(new_year_release:Int):Novel = {
    new Novel(this.name, new_year_release, this.author)
  }
}



/*
  Counter class
  - receives an int value
  - method current count
  - method to increment/decrement -> new Counter
  - overload increment/decrement to receive an amount => new Counter
 */

class Counter(val counter: Int = 0) {

  def inc = {
    println("Incrementing")
    new Counter(counter + 1) // immutability
  }
  def dec = {
    println("Decrementing")
    new Counter(counter - 1)
  }

  // If we want to log output, then we should iterate them to show log n times instead of showing a single log of n
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print() = println(counter)
}
