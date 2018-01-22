#!/usr/bin/env scala
println("---types---")

val list: List[Any] = List(
  "a string",
  732,
  'c',
  true,
  () => "an anonymous function"
)
list.foreach(element => println(element))

println("---types casting---")

val byte: Byte = 1
val short: Short = byte
val char: Char = 'a'
val int: Int = char
val long: Long = int
val float: Float = long
val double: Double = float

println(byte)
println(short)
println(char)
println(int)
println(long)
println(float)
println(double)
