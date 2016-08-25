package ActorsAndConcurrency

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.util.Random

/**
  * Created by baohg on 11/08/2016.
  */
class RunningMultipleCalcs extends App {
  println("starting futures")
  val result1 = Cloud.runAlgorithm(10)
  val result2 = Cloud.runAlgorithm(20)
  val result3 = Cloud.runAlgorithm(30)

  println("before for-comprehension")
  val result = for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield (r1 + r2 + r3)
  println("before onSuccess")
  result onSuccess {
    case result => println(s"total = $result")
  }
  println("before sleep at the end")
  sleep(2000) // keep the jvm alive

  def sleep(time: Long) { Thread.sleep(time) }
}

object Cloud {
  def runAlgorithm(i: Int): Future[Int] = Future {
    sleep(Random.nextInt(500))
    val result = i + 10
    println(s"returning result from cloud: $result")
    result
  }
  def sleep(time: Long) { Thread.sleep(time) }
}
