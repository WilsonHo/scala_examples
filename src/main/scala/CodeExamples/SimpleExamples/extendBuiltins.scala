package CodeExamples.SimpleExamples

/**
  * Created by baohg on 25/08/2016.
  */
object extendBuiltins extends App {
  def fact(n: Int): BigInt =
    if (n == 0) 1 else fact(n - 1) * n

  def increment(n: Int): BigInt =
    n + 1

  class Factorizer(n: Int) {
    def ! = fact(n)

    def ++ = increment(n)
  }

  implicit def int2fact(n: Int) = new Factorizer(n)

  println("10! = " + (10 !))
  println("10++ = " + (10 ++))
}
