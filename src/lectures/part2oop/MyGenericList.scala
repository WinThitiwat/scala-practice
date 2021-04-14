package lectures.part2oop

abstract class MyGenericList[+A] {

  /*
    def head = return first element of the list
    def tail = return remainder of the list
    def isEmpty = is this list empty
    def add(int) => return new list with this elm added
    def toString => a string representation of the list
   */

  def head: A
  def tail: MyGenericList[A]
  def isEmpty: Boolean
  def add[B >: A] (elm: B): MyGenericList[B]
  def printElements: String

  // polymorphic call
  override def toString: String = "["+ printElements +"]"

}
// Nothing type is a proper substitute for any type
// and the object Empty should be a proper substitute of my list of any type
// so the Empty object should extends of Nothing type
object EmptyList extends MyGenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyGenericList[Nothing] =  throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](elm: B): MyGenericList[B] = new Node(elm, EmptyList)
  def printElements:String = ""
}

class Node[+A] (h: A, t: MyGenericList[A]) extends MyGenericList[A] {
  def head: A = h
  def tail: MyGenericList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](elm: B): MyGenericList[B] = new Node(elm, this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest2 extends App {
  val integersList: MyGenericList[Int] = EmptyList
  val stringsList: MyGenericList[String] = EmptyList // Empty is a proper value for an empty list of strings

  val listOfInts: MyGenericList[Int] = new Node(1, new Node(2, new Node(3, EmptyList)))
  val listOfStrs: MyGenericList[String] = new Node("Hello", new Node("World", EmptyList))

  println(listOfInts.toString)
  println(listOfStrs.toString)

}
