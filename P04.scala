// 正の整数のリストを与えられたとき、数を並び替えて可能な最大数を返す関数を記述せよ。
// 例えば、[50,,, 9]が与えられた時、95021が答えとなる

object P04 {
  def toMaxNum(list: List[BigInt]) : BigInt = {
    val sort: (BigInt,BigInt) => Boolean = (a:BigInt, b:BigInt) => {
      a.toString + b.toString > b.toString + a.toString
    }
    BigInt(list.sortWith(sort).mkString)
  }
}

val list = List[BigInt](3,34,32,5,50,53)

printf("%s: %d", "make the maximum number.", P04.toMaxNum( list ))

// 桁が違う時の比較がうまくいかない
// val list2 = List(3,34,32,5)
// println( list2.sortBy(_.toString).reverse.mkString.toInt)


