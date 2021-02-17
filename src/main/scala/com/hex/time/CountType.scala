package com.hex.time

object CountType extends Enumeration {
	type CountType = Value
	val UP_TO, DOWN_FROM, UNKNOWN_TYPE= Value
	def valueOf(name: String): CountType = {
		if(name.contains("up")) CountType.UP_TO else if(name.contains("down")) CountType.DOWN_FROM else CountType.UNKNOWN_TYPE
	}
}