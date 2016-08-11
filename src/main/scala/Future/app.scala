package Future

import com.google.common.util.concurrent.Futures

import actors._

/**
  * Created by baohg on 11/08/2016.
  */
object app {
  def main(args: Array[String]) {

//    def asyncify[A, B](f: A => B): A => Future[B] = (a => Futures.future(f(a)))
//
//    // normally blocks when called
//    def sleepFor(seconds: Int) = {
//      Thread.sleep(seconds * 1000)
//      seconds
//    }
//
//    val asyncSleepFor = asyncify(sleepFor)
//    val future = asyncSleepFor(5) // now it does NOT block
//    println("waiting...") // prints "waiting..." rightaway
//    println("future returns %d".format(future())) // prints "future returns 5" after 5 seconds
  }
}
