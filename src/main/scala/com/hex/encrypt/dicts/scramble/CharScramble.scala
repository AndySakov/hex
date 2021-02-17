package com.hex.encrypt.dicts.scramble

object CharScramble {
	private val dict: Map[String, String] = Map(
		"~" -> "/",
		"`" -> "?",
		"!" -> ".",
		"@" -> ">",
		"#" -> ",",
		"$" -> "<",
		"%" -> "\"",
		"^" -> "\'",
		"&" -> ":",
		"*" -> ";",
		"(" -> "\\",
		")" -> "|",
		"_" -> "]",
		"-" -> "}",
		"+" -> "[",
		"=" -> "{",
		"{" -> "=",
		"[" -> "+",
		"}" -> "-",
		"]" -> "_",
		"|" -> ")",
		"\\" -> "(",
		";" -> "*",
		":" -> "&",
		"\'" -> "^",
		"\"" -> "%",
		"<" -> "$",
		"," -> "#",
		">" -> "@",
		"." -> "!",
		"?" -> "`",
		"/" -> "~"
	)
	
	/**
	 * encode(data: String): String = one char at a time conversion of the letters
	 *
	 * @param data the char to scramble
	 * @return String representation of the scrambled char for the param
	 */
	def encode(data: String): String = {
		data.split("").map(x => dict.getOrElse(x, x)).mkString
	}
	
	/**
	 * decode(data: String): String = one code code at a time conversion of the codes
	 * @param data the encoder.language.MorseCode code to convert to english letters
	 * @return String representation of the english form of the param
	 */
	def decode(data: String): String = {
		data.split("").map(x => dict.getOrElse(x, x)).mkString
	}
}
