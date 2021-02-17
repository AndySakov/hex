package com.hex.collection

import scala.util.Random


class Collection[A](x: A*) extends Seq[A]{
  
  def randElement: A = x(Random.nextInt(x.length))
  
  def shuffle: Collection[A] = {
    new Collection(Random.shuffle(x): _*)
  }
  
  override def length: Int = x.length
  
  override def apply(idx: Int): A = x(idx)
  
  override def iterator: Iterator[A] = x.iterator
}

object Collection{
  def apply[A](x: A*): Collection[A] = new Collection(x: _*)
}
