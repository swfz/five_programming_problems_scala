// 最初の100個のフィボナッチ数のリストを計算する関数を記述せよ。
// 定義では、フィボナッチ数列の最初の2つの数字は0と1で、次の数は前の2つの合計となる。
// 例えば最初の10個のフィボナッチ数列は、0,,,,,,, 13, 21, 34となる。

object P03 {
  def fibonacciIn(n: Int ) : Int ={
    n match {
      case 1 => 0
      case 2 => 1
      case _ => fibonacciIn(n - 2) + fibonacciIn(n - 1)
    }
  }
  def numToFibonacciList(n: Int) : List[Int] = {
    n match {
      case 1 => List(fibonacciIn(1))
      case _ => numToFibonacciList(n-1):::List(fibonacciIn(n))
    }
  }
}


printf("%s: %s", "number to fibonacci", P03.numToFibonacciList(10) )

// こちらの方が末尾再帰なので早い
object P03_2 {
  // 末尾再帰最適化
  def fibonacci(n: Int, a1: BigInt = 0, a2:BigInt = 1) : BigInt ={
    n match {
      case 0|1 => a1
      case _   => fibonacci( n - 1, a1 + a2, a1 )
    }
  }
  def numToFibonacciList(n: Int) : List[BigInt] = {
    n match {
      case 1 => List(fibonacci(1))
      case _ => numToFibonacciList(n-1):::List(fibonacci(n))
    }
  }
}

printf("%s: %s", "number to fibonacci", P03_2.numToFibonacciList(10) )

// Streamを使う
val fib:Stream[Int] = 0 #:: fib.scanLeft(1){_ + _}
fib.take(10).toList





