package ActorsAndConcurrency

import akka.actor.{Props, ActorSystem, Actor}
import akka.actor.Actor.Receive

/**
  * Created by baohg on 11/08/2016.
  */
class HelloActor(myName: String) extends Actor {
  override def receive: Receive = {
    // (2) println statements changed to show the name
    case "hello" => println(s"hello from $myName")
    case _
    => println(s"'huh?', said $myName")
  }
}

object Main extends App {
  // an actor needs an ActorSystem
  val system = ActorSystem("HelloSystem")
  // create and start the actor
  val helloActor = system.actorOf(Props(new HelloActor("Fred")), name = "helloactor")
  // send the actor two messages
  helloActor ! "hello"
  helloActor ! "buenos dias"
  // shut down the system
  system.shutdown
}