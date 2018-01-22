#!/usr/bin/env scala
println("---classes---")

class Greeter(prefix: String, suffix: String){
  // Unit return type is similar with void in Java
  def greet(name: String): Unit = println(prefix + name + suffix)
}
var greeter = new Greeter("Hello, ", "!")
greeter.greet("Scala developer")
