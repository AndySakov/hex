package com.hex.encrypt.globals

import java.nio.file.{Files, Path}
import java.util.Random

object Sys {
	def temp(name: String): Path = Files.createTempFile(name, s"${new Random().nextInt(20000)}.hex")
}
