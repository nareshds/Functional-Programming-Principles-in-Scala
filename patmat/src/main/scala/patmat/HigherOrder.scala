package patmat

/**
  * Created by ndharmas on 05-Oct-16.
  */
object HigherOrder {
  def squareList(xs:List[Int]) : List[Int] = xs match {
    case Nil => xs
    case x :: xs1 => x * x :: squareList(xs1)
  }

  def squareListUsingMap(xs: List[Int]) : List[Int] = xs map(x => x * x)

  def main(args: Array[String]) {
    val nums = List(1,2,3, 4,5)
    val chars = List("ab", "cd", "ef")
    println(squareList(nums))
    println(squareListUsingMap(nums))
  }
}
