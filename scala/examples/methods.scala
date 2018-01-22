#!/usr/bin/env scala
println("---methods---")

def add(x: Int, y: Int): Int = x + y
println(add(1, 2))

def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(1, 2)(3))

def name: String = System.getProperty("user.name")
println("Hello, " + name + "!")

def square(number: Double): Double = {
  number * number
}
println(square(2.3))
