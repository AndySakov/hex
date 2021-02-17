package com.hex.db

import java.sql.{Connection, DriverManager, Statement}

trait DB {
  protected var timeout: Int = 1000
  protected var driver: String= ""
  protected var url: String = ""
  protected var user: String = ""
  protected var pass: String = ""
  protected var db: String = ""
  
  Class.forName(driver)
  lazy val conn: Connection = DriverManager.getConnection(url, user, pass)
  lazy val state: Statement = conn.createStatement()

  def connect(): Boolean = {
    state.execute(s"SELECT * FROM $db")
    conn.isValid(timeout)
  }

  def setTimeout(int: Int): this.type ={
    this.timeout = int
    this
  }
  
  def setDriver(driver: String): this.type = {
    this.driver = driver
    this
  }
  
  def setUrl(url: String): this.type = {
    this.url = url
    this
  }
  
  def setUser(user: String): this.type = {
    this.user = user
    this
  }
  
  def setPass(pass: String): this.type = {
    this.pass = pass
    this
  }
  
  def setDb(db: String): this.type = {
    this.db = db
    this
  }

}
