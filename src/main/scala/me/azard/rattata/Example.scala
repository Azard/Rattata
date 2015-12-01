package me.azard.rattata
import me.azard.rattata.Rattata
import scala.reflect.runtime.universe._

object Example extends App{

  val exp = reify {
    val x = 1
    val y = 2
    x + y
  }

  println(showRaw(exp))
  Rattata.pprintAST(exp)
  //Rattata.setTabSize(2).pprintAST(exp)
  //Rattata.setShowLine(false).pprintAST(exp)
  //Rattata.setTabSize(2).setShowLine(false).pprintAST(exp)
}
