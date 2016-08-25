package CodeExamples.SimpleExamples

/**
  * Created by baohg on 25/08/2016.
  */
object implicits extends App {
  implicit def arrayWrapper[A: ClassManifest](x: Array[A]) =
    new {
      def sort(p: (A, A) => Boolean) = {
        util.Sorting.stableSort(x, p);
        x
      }
    }

  val x = Array(2, 3, 1, 4)
  println("x = " + x.sort((x: Int, y: Int) => x < y))
}
