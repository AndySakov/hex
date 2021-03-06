package com.hex.file

import java.io.File

class SuperFile(val path: String) extends File(path){
	def ext: String = {
		if(isDirectory){
			""
		}else{
			getName.split("").splitAt(getName.split("").lastIndexOf("."))._2.mkString.tail
		}
	}
	
	def name: String = {
		if(this.isDirectory){
			getName
		}else{
			getName.split("").splitAt(getName.split("").lastIndexOf("."))._1.mkString
		}
	}
	
	def pwd: String = {
		val f = new File(".").getAbsolutePath
		f.substring(0, f.length - 1)
	}
}

object SuperFile{
	def apply(path: String): SuperFile = new SuperFile(path)
	def fromFile(x: File): SuperFile = new SuperFile(x.getAbsolutePath)
}
