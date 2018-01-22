#!/usr/bin/env scala
println("---functions---")

val addOne = (x: Int) => x + 1
println(addOne(1))

val add = (x: Int, y: Int) => x + y
println(add(1, 2))

val noArgs = () => "Hi"
println(noArgs())
