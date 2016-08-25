package ActorsAndConcurrency

import scala.concurrent.Future
import scala.util.{Success, Failure, Random}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by baohg on 11/08/2016.
  */
object Futures2 extends App {
  implicit val baseTime = System.currentTimeMillis

  def longRunningComputation(i: Int): Future[Int] = Future {
    sleep(100)
    i + 1
  }

  // this does not block
  longRunningComputation(11).onComplete {
    case Success(result) => println(s"result = $result")
    case Failure(e) => e.printStackTrace
  }
  // keep the jvm from shutting down
  sleep(1000)

  def sleep(time: Long) { Thread.sleep(time) }
}
