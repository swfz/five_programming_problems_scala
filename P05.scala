// 1,2,…,9の数をこの順序で、”+”、”-“、またはななにもせず結果が100となるあらゆる組合せを出力するプログラムを記述せよ。
// 例えば、1 + 2 + 34 – 5 + 67 – 8 + 9 = 100となる

object P05 {
  val plus  = """(.*)\+([0-9]+)""".r
  val minus = """(.*)\-([0-9]+)""".r
  val single = """([0-9]+)""".r

  def listCombinationExpect(list: List[Int], exp: Int): List[Any] = {
      val patterns = toPatterns(list.tail.head,list.tail.tail,List(list.head))
      for(l <- patterns; if calc(l.toString) == exp ) yield l
  }
  def calc(str: String): Int ={
    str match {
      case plus(h,t)   => calc(h) + t.toInt
      case minus(h,t)  => calc(h) - t.toInt
      case single(num) => num.toInt
    }
  }
  val op = List("+","-","")
  def toPatterns(n: Int,list: List[Int], tmp: List[Any]): List[Any] ={

    val result = for(item <- tmp; o <- op) yield item + o + n

    list match {
      case head::tail => toPatterns(head,tail,result)
      case _ => result
    }
  }
}

val list     = List(1,2,3,4,5,6,7,8,9)
val expected = 100
println(P05.listCombinationExpect(list,expected))

