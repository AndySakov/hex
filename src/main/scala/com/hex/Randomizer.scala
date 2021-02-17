package com.hex

import scala.util.Random

object Randomizer {
	def randomToken(length: Int): String = {
		val lower = List.range('a', 'z').map(_.toString)
		val upper = lower.map(_.toUpperCase)
		val numbers = 0::List.range(1,10)
		val special = "!@#$&?"
		val all = (lower.mkString("")+upper.mkString("")+numbers.mkString("")+special).split("")
		val ty = for(x <- 1 to length) yield {
			all(Random.nextInt(all.length))
		}
		ty.mkString("")
	}
}
