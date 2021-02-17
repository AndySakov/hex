package com.hex.encrypt.dicts.bsr.compress

import java.io.File
import java.nio.file.Files

object BSR extends App{
	println("Bit Spline Reticulation Test 1")
	val test = new File("C:/Users/lenovo/Documents/scripts.txt")
//	Extractor().extract(test)
	println("Number of bytes in file"+Files.readAllBytes(test.toPath).length)
}
