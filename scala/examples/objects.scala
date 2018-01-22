#!/usr/bin/env scala
println("---objects---")

object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter +=1
    counter
  }
}

println("---object have only one instance---")
println(IdFactory.create())
println(IdFactory.create())
