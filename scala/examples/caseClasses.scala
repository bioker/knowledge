#!/usr/bin/env scala
println("---case classes---")

case class Point(x: Int, y: Int)

val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)

println("---compared by value---")
println(point == anotherPoint)
println(point == yetAnotherPoint)
