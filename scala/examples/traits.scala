#!/usr/bin/env scala
println("---traits---")

trait Greeter {
  def greet(name: String): Unit
}

trait Greeter2 {
  def greet(name: String): Unit = {
    println("Hello, " + name + "!")
  }
}

class DefaultGreeter extends Greeter2

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter2 {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val greeter = new DefaultGreeter()
greeter.greet("Scala developer")

val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer")
