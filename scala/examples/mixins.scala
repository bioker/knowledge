#!/usr/bin/env scala
import scala.collection.mutable.ArrayBuffer

println("---Mixins---")

trait Material { 
  def density(): Float
}

trait Wood extends Material{
  override def density(): Float = 0.1f
}

trait Metal extends Material {
  override def density(): Float = 1f
}

trait Silk extends Material {
  override def density(): Float = 0.01f
}

class WoodTable extends Wood

class MetalTable extends Metal

class WoodMetalTable extends Metal with Wood 

class SilkWoodMetalTable extends Metal with Wood with Silk

val items = ArrayBuffer.empty[Material]
items.append(new WoodTable())
items.append(new MetalTable())
items.append(new WoodMetalTable())
items.append(new SilkWoodMetalTable())

items.foreach(item => println(item.density()))
