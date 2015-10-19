// 交互に要素を取ることで、2つのリストを結合する関数を記述せよ。例えば [a,, c]と[1,, 3]という2つのリストを与えると、関数は [a,,,,, 3]を返す。

object P02 {
  def toInterchangeList(listA: List[Any], listB: List[Any]): List[Any] = {
    (listA,listB) match {
      case (aFirst::aRest,bFirst::bRest) => aFirst::bFirst::toInterchangeList(aRest,bRest)
      case (aFirst::aRest, bFirst::Nil)  => aFirst::bFirst::toInterchangeList(aRest,List())
      case (aFirst::aRest, List())       => aFirst::toInterchangeList(aRest,List())
      case (aFirst::Nil, bFirst::bRest)  => aFirst::bFirst::toInterchangeList(List(),bRest)
      case (List(), bFirst::bRest)       => bFirst::toInterchangeList(List(),bRest)
      case (_,_) => List()
    }
  }
}
val sameA = List(1,2,3)
val sameB = List("a","b","c")
printf("%s: %s","same size A and B", P02.toInterchangeList(sameA,sameB))

val largeA = List(1,2,3,4,5,6)
val smallB = List("a","b","c")
printf("%s: %s","A is greater than B", P02.toInterchangeList(largeA,smallB))

val smallA = List(1,2,3)
val largeB = List("a","b","c","d","e","f")
printf("%s: %s","A is less than B", P02.toInterchangeList(smallA,largeB))

