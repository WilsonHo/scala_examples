package CodeExamples.SimpleExamples

/**
  * Created by baohg on 25/08/2016.
  */
object forYield {
  def main(args: Array[String]) {
    val input: Array[String] = Array("Zara", "Nuha", "Ayan")
    val res = for (a <- args) yield a.toUpperCase
    for (a <- res) yield println("Arguments: " + a)

  }
}
