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

printf("%s: %s", "number to fibonacci:", P03.numToFibonacciList(100) )

