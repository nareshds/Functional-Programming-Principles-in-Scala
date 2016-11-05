package funsets

object Main extends App {
  import FunSets._
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)
  val s4 = union(s3, union(s1, s2))
  val s5 = s1
  val setPositiveNumbers = union(singletonSet(1), singletonSet(300))
  val setNegativeNumbers = union(singletonSet(-10), singletonSet(-99))
  val setPositiveAndNegativeNumbers = union(setPositiveNumbers, setNegativeNumbers)
  val setEvenNumbers = union(singletonSet(4), singletonSet(6))
  val setOddNumbers = union(singletonSet(3), singletonSet(9))
  val setEvenAndOddNumbers = union(setEvenNumbers, setOddNumbers)

  val u = union(s3,union(s1, s2))
  val i = intersect(s4, s3)
  val f = filter(s1, {elem: Int => elem < 1})
  val m = map(setEvenNumbers, { elem:Int => elem + 1})
  //val e = exists(s)
  //printSet(u)
  //printSet(i)
  //printSet(f)
  printSet(m)
  //println(contains(singletonSet(2), 1))
}
