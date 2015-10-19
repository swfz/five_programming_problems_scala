object P01 {
  def listTotalUsingFor(args: List[Int]) : Int = {
    var sum = 0
    for(n <- args){
      sum += n
    }
    sum
  }

  def listTotalUsingWhile(args: List[Int]) : Int = {
    var sum = 0
    val it  = args.toIterator
    while(it.hasNext){
      sum += it.next()
    }
    sum
  }

  def listTotalUsingRecurse(args: List[Int]) : Int = {
    args match {
      case Nil => 0
      case first::rest => first + listTotalUsingRecurse(rest)
    }
  }
}

val list = List(1,2,3,4,5)
printf("%s: %d\t","Using For",     P01.listTotalUsingFor(list))
printf("%s: %d\t","Using While",   P01.listTotalUsingWhile(list))
printf("%s: %d\t","Using Recurse", P01.listTotalUsingRecurse(list))


