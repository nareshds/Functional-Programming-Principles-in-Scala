package patmat

/**
  * Created by ndharmas on 05-Oct-16.
  */
object MergeSort {
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if(n == 0) xs
    else {
      val (fst, snd) = xs splitAt n
      modifiedMerge(msort(fst), msort(snd))
    }
  }


  def polymorphicMsort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length/2
    if(n == 0) xs
    else {
      val(fst, snd) = xs splitAt n
      polymorphicMerge(polymorphicMsort(fst), polymorphicMsort(snd))
    }
  }


  /**
    * trival merge method
    *
    * @param xs
    * @param ys
    * @return
    */
  def merge(xs : List[Int], ys : List[Int]) : List[Int] = xs match {
    case Nil => ys
    case x :: xs1 =>
      ys match {
        case Nil => xs
        case y :: ys1 => if(x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
  }

  /**
    * play with tuples
    *
    * @param xs
    * @param ys
    * @return
    */
  def modifiedMerge(xs: List[Int], ys: List[Int]) : List[Int] = (xs, ys) match {
    case (Nil, ys) => ys
    case (xs, Nil) => xs
    case (x :: xs1, y :: ys1) => if(x < y) x :: modifiedMerge(xs1, ys) else y :: modifiedMerge(xs, ys1)
  }

  def polymorphicMerge[T](xs: List[T], ys: List[T])(implicit ord: Ordering[T]): List[T] = (xs, ys) match {
    case (Nil, ys) => ys
    case (xs, Nil) => xs
    case (x::xs1, y::ys1) => if(ord.lt(x,y)) x::polymorphicMerge(xs1, ys) else y :: polymorphicMerge(xs, ys1)
  }

  def main(args: Array[String]) {
    val nums = List(2,8,1,6,-7,9,0)
    val fruits = List("pear", "guava", "grape", "apple", "pineapple", "orange")

    println(msort(nums))

    println(polymorphicMsort(fruits))
  }
}
