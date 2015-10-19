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

