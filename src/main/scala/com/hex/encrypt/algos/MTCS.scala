package com.hex.encrypt.algos

import com.hex.encrypt.dicts.lang.Morse
import com.hex.encrypt.dicts.scramble.CharScramble

object MTCS {
  def encrypt(data: String): String = CharScramble.encode(Morse.encode(data))
  def decrypt(data: String): String = Morse.decode(CharScramble.decode(data))
}
