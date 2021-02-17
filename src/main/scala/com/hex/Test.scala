package com.hex

import com.hex.encrypt.algos.MTCS

object Test {
  def main(args: Array[String]): Unit = {
    val name = "Mike Kehinde"
    println("Plain text: "+name)
    val je = MTCS.encrypt(name)
    println("Encrypted: "+je)
    println("Decrypted: "+MTCS.decrypt(je))
    assert(je == "\\;]])!!)]!])!)*);]!])!)!!!!)!!)]!)]!!)!|")
  }
}
