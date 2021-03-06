package com.hex.db

import java.sql.{Connection, DriverManager, Statement}

trait DB {
  protected def timeout: Int = 1000
  protected def driver: String
  protected def url: String
  protected def user: String
  protected def pass: String
  protected def db: String
  
  Class.forName(driver)
  private lazy val conn: Connection = DriverManager.getConnection(url, user, pass)
  private lazy val state: Statement = conn.createStatement()

  def connect(): Boolean = {
    state.execute(s"SELECT * FROM $db")
    conn.isValid(timeout)
  }

}
