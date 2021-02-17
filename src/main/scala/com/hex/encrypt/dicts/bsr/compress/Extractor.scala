package com.hex.encrypt.dicts.bsr.compress

import java.io._

import com.hex.file.SuperFile

/**
	* The class containing all the functionality for extracting the bits
  * from the target zip file and turns them to <code>XBytes</code>
	*
  */
class Extractor {
	case class XByte(index: Int, byte: Byte)

	case class ZipFile(file: File) {
		def isZip: Boolean = SuperFile.fromFile(file).ext == "zip"
	}

//	def extract(target: ZipFile): File ={
//		if(target.isZip){
//			val f = target.file
//			val temp = Sys.temp(f.getName.split("").splitAt(f.getName.split("").lastIndexOf("."))._1.mkString).toFile
//			Source.fromFile(f).reader()
//		} else {
//			throw new UnsupportedOperationException("File is not a zip")
//		}
//	}
}

object Extractor{
	def apply(): Extractor = new Extractor()
}
