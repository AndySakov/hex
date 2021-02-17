package com.hex.encrypt.dicts.lang

import java.util.NoSuchElementException

/**
 * MorseCode code definition
 */
object Morse {
	/**
	 * Mapping of letters of the english alphabet to their <code>encoder.language.MorseCode</code> code equivalents
	 */
	private val dict: Map[String, String] = Map(
		"a" -> "._", "A" -> "*._", "1" -> ".----",
		"b" -> "_...", "B" -> "*_...", "2" -> "..---",
		"c" -> "_._.", "C" -> "*_._.", "3" -> "...--",
		"d" -> "_..", "D" -> "*_..", "4" -> "....-",
		"e" -> ".", "E" -> "*.", "5" -> ".....",
		"f" -> ".._.", "F" -> "*.._.", "6" -> "-....",
		"g" -> "__.", "G" -> "*__.", "7" -> "--...",
		"h" -> "....", "H" -> "*....", "8" -> "---..",
		"i" -> "..", "I" -> "*..", "9" -> "----.",
		"j" -> ".___", "J" -> "*.___", "0" -> "-----",
		"k" -> "_._", "K" -> "*_._",
		"l" -> "._..", "L" -> "*._..",
		"m" -> "__", "M" -> "*__",
		"n" -> "_.", "N" -> "*_.",
		"o" -> "___", "O" -> "*___",
		"p" -> ".__.", "P" -> "*.__.",
		"q" -> "__._", "Q" -> "*__._",
		"r" -> "._.", "R" -> "*._.",
		"s" -> "...", "S" -> "*...",
		"t" -> "_", "T" -> "*_",
		"u" -> ".._", "U" -> "*.._",
		"v" -> "..._", "V" -> "*..._",
		"w" -> ".__", "W" -> "*.__",
		"x" -> "_.._", "X" -> "*_.._",
		"y" -> "_.__", "Y" -> "*_.__",
		"z" -> "__..",  "Z" -> "*__.."
	)
	
	/**
	 * encode(data: String): String = one letter at a time conversion of the letters
	 *
	 * @param data the english data to <code>convert</code> to <code>encoder.language.MorseCode</code> code
	 * @return String representation of the <code>encoder.language.MorseCode</code> code for the param
	 */
	def encode(data: String): String = {
		def isWord(string: String): Boolean = string.split("").length > 1
		def isLetter(string: String): Boolean = string.split("").length == 1
		
		def wordEncode(s: String): String = {
			val letters = s.split("")
			val push = letters.map(letterEncode)
			val done = push.mkString("(", "|", ")")
			done
		}
		
		def letterEncode(s: String): String = {
			if(s.equals(".")){
				"?"
			}else if(s.equals("_")){
				"~"
			}else if(s.equals(" ")){
				";"
			}else if(s.equals("\t")){
				"\t"
			}else{
				try{
					s"${List(s).flatMap(dict.get).head}"
				}catch {
					case _:NoSuchElementException =>
						println(s"Char $s has no morse code equivalent")
						s
				}
			}
		}
		def sLetterEncode(s: String): String = {
			if(s.equals(".")){
				"?"
			}else if(s.equals("_")){
				"~"
			}else if(s.equals(" ")){
				";"
			}else if(s.equals("\t")){
				"\t"
			}else{
				try {
					s"(${List(s).flatMap(dict.get).head})"
				} catch {
					case _: NoSuchElementException =>
						println(s"Char $s has no morse code equivalent")
						s
				}
			}
		}
		
		if(isWord(data)){
			wordEncode(data)
		}else if(isLetter(data)){
			sLetterEncode(data)
		}else{
			s"$data"
		}
	}
	
	/**
	 * decode(data: String): String = one code code at a time conversion of the codes
	 * @param data the encoder.language.MorseCode code to convert to english letters
	 * @return String representation of the english form of the param
	 */
	def decode(data: String): String = {
		def isWord(morse: String): Boolean = morse.split("").contains("|")
		def isLetter(morse: String): Boolean = !isWord(morse)
		
		
		def letterDecode(m: String): String = {
			if(m.equals("?")){
				"."
			}else if(m.equals("~")){
				"_"
			}else if(m.equals(";")){
				" "
			}else if(m.equals("\t")){
				"\t"
			}else{
				val all = m.split("")
				val p = all.filterNot(x => x.equals("(")).filterNot(y => y.equals(")")).mkString
				try {
					dict.filter(x => x._2 == p).head._1
				} catch {
					case _: NoSuchElementException =>
						m
				}
			}
		}
		
		def pLetterDecode(m: String): String ={
			if(m.equals("?")){
				"."
			}else if(m.equals("~")){
				"_"
			}else if(m.equals(";")){
				" "
			}else if(m.equals("\t")){
				"\t"
			}else{
				try {
					dict.filter(x => x._2 == m).head._1
				} catch {
					case _: NoSuchElementException =>
						println(s"Char $m has no english equivalent")
						m
				}
			}
		}
		
		def wordDecode(m: String): String = {
			val all = m.split("")
			val letters = all.flatMap(x => if(x.equals("|")) " " else x)
			val ty = letters.mkString.split(" ")
			val brokenHead = ty.head.split("")
			val noBrh = brokenHead.filterNot(x => x.equals(brokenHead.head))
			val head = Array(noBrh.mkString)
			val brokenTail = ty.last.split("")
			val noBrt = brokenTail.filterNot(x => x.equals(brokenTail.last))
			val tail = Array(noBrt.mkString)
			val mid = ty.filterNot(x => x.equals(ty.head)).filterNot(p => p.equals(ty.last))
			val end = head ++ mid ++ tail
			val de = end.flatMap(pLetterDecode).mkString
			de
		}
		
		if(isLetter(data)){
			letterDecode(data)
		}else if(isWord(data)){
			wordDecode(data)
		}else{
			"?"
		}
	}
}
