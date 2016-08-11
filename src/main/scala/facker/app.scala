package facker

/**
  * Created by baohg on 11/08/2016.
  */

import fabricator._;

case class User(name: String, username: String, email: String)

object app {
  def main(args: Array[String]) {
    val alpha = fabricator.Alphanumeric() //.alphaNumeric() // initialize alpha numeric module
    println(alpha.numerify("###ABC"))
    println(alpha.letterify("???123")) // LsQ123
  }

}
