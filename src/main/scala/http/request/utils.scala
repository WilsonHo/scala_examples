package http.request

/**
  * Created by baohg on 25/07/2016.
  */
object utils {
  def randBetween(start: Int, end: Int): Int = {
    start + Math.round(Math.random() * (end - start)).toInt;
  }
}
