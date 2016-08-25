package ActorsAndConcurrency

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by baohg on 11/08/2016.
  */

object Futures1 extends App {
  // used by 'time' method
  implicit val baseTime = System.currentTimeMillis

  // 2 - create a Future
  val f = Future {
    sleep(5000)
    1 + 1
  }

  // 3 - this is blocking (blocking is bad)
  val result = Await.result(f, 4 second)
  println(result)
  sleep(1000)

  def sleep(time: Long) { Thread.sleep(time) }
}
