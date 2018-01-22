#!/usr/bin/env scala

println("---process output---")

println(1)
println(1 + 1)
println("Hello" + " World!")

println("---values---")

val x = 1 + 1
println(x)

// val can't be reassigned
// x = 3
// provides compile error

println("---variables---")

var y = 2 + 2
println(y)
// var can be reassigned
y = 3
println(y)
