package CodeExamples.SimpleExamples

/**
  * Created by baohg on 25/08/2016.
  */
/** Bigint's can be used seamlessly */
object bigint extends App {
  def factorial(n: BigInt): BigInt =
    if (n == 0) 1 else n * factorial(n - 1)

  val f50 = factorial(100);
  val f49 = factorial(99)
  println("50! = " + f50)
  println("49! = " + f49)
  println("50!/49! = " + (f50 / f49))
}