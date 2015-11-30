package me.azard.rattata

import scala.reflect.runtime.universe._

object Rattata {

  private var showLine = true
  private var tabSize = 4

  def setShowLine(show: Boolean) = {
    showLine = show
    this
  }

  def setTabSize(size: Int) = {
    if (size > 0) {
      tabSize = size
    } else {
      println("Warning: setTabSize only receive positive number")
    }
    this
  }

  def pprintAST(input: Expr[Any]) = {
    var level = 0
    showRaw(input).foreach {
      case '(' =>
        level += 1
        println()
        if (showLine) {
          print(("|" + " "*(tabSize-1)) * (level-1))
          print("|" + "-"*(tabSize-1))
        } else {
          print(" " * tabSize * level)
        }
      case ')' =>
        level -= 1
      case ',' =>
        println()
        if (showLine) {
          print(("|" + " "*(tabSize-1)) * (level-1))
          print("|" + "-"*(tabSize-1))
        } else {
          print(" " * tabSize * level)
        }
      case ' ' =>
      case f => print(f)
    }
  }

}
