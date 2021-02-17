package com.hex.time

import com.hex.time.CountType.CountType

object Timer {
  def timedTask[A](task: => A): (A, Double) = {
    val start = System.nanoTime()
    val result = task
    val end = System.nanoTime()
    val latency = (end-start)/1000000d
    (result, latency)
  }
  
  def doAt[A](time: Long, task: => A): Unit = {
    new Thread{
      Thread.sleep(time)
      task
    }
  }

  def doTogether(tasks: Unit*): Unit = {
    tasks.foreach(x => {
      new Thread{
        x
      }
    })
  }

  def count(direction: CountType, amount: Int): Unit = {
    direction match {
      case CountType.DOWN_FROM =>
        for(x <- (1 to amount).reverse) {
          println(x)
          Thread.sleep(1000)
        }
      case CountType.UP_TO =>
            for(x <- 1 to amount) {
              println(x)
              Thread.sleep(1000)
            }
      case CountType.UNKNOWN_TYPE =>
            println("Unknown Type")
    }
  }

  def main(args: Array[String]): Unit = {
    doTogether(List{
      List.range(1, 10001).reverse.map(_*8).foreach(println)
      println("A")
      println(List.range(1, 10001).reverse.map(_*2).mkString(","))
      println(List.range(1, 10001).reverse.map(_*3).mkString(","))
    })
  }
}