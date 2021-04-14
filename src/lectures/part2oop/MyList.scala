package lectures.part2oop

abstract class MyList {

  /*
    def head = return first element of the list
    def tail = return remainder of the list
    def isEmpty = is this list empty
    def add(int) => return new list with this elm added
    def toString => a string representation of the list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(elm: Int): MyList
  def printElements: String

  // polymorphic call
  override def toString: String = "["+ printElements +"]"

}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList =  throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(elm: Int): MyList = new Cons(elm, Empty)
  def printElements:String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(elm: Int): MyList = new Cons(elm, this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val node1 = new Cons(3, Empty)
  val node2 = new Cons(2, node1)
  val list = new Cons(1, node2)
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString)
}
