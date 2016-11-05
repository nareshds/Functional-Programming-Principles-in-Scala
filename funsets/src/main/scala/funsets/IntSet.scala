package funsets

/**
  * Created by ndharmas on 19-Sep-16.
  */
abstract class IntSet {
  def incl(x:Int) : IntSet
  def contains(x:Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def incl(x: Int): IntSet =  new NonEmpty(x, Empty, Empty)

  def contains(x: Int): Boolean = false

  def union(other: IntSet): IntSet = other

  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet =
    if(elem < x) new NonEmpty(elem, left incl x, right)
    else if (elem > x) new NonEmpty(elem, left, right incl x)
    else this

  def contains(x: Int): Boolean =
    if(elem < x) left contains x
    else if(elem > x) right contains x
    else true

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem

  override def toString = "{ " + left + elem +right +"}"

}

object Test {
  def main(Args: Array[String]): Unit ={
    var one = Empty contains 2
    println(one.toString)
    val two = Empty incl 2
    println(two.toString)

    val union = Empty incl 3 union two
    println(union.toString)
  }
}
