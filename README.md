# Rattata

![Rattata](./Rattata.png)

Rattata is a Scala Abstract Syntax Tree(AST) pretty print tool.

Scala: 2.11.7

## Usage


## Example
When use Scala AST to write macro, do pattern match or something else, it will be helpful to read a pretty print AST.

Here is a Scala AST

``` Scala
import scala.reflect.runtime.universe._
val exp = reify {
  val x = 1
  val y = 2
  x + y
}
```

Use original `showRaw`

``` Scala
scala> println(showRaw(exp))
Expr(Block(List(ValDef(Modifiers(), TermName("x"), TypeTree(), Literal(Constant(1))), ValDef(Modifiers(), TermName("y"), TypeTree(), Literal(Constant(2)))), Apply(Select(Ident(TermName("x")), TermName("$plus")), List(Ident(TermName("y"))))))
```

Use `Rattata.pprintAST`

``` Scala
scala> import me.azard.rattata.Rattata
import me.azard.rattata.Rattata

scala> Rattata.pprintAST(exp)
Expr
|---Block
|   |---List
|   |   |---ValDef
|   |   |   |---Modifiers
|   |   |   |   |---
|   |   |   |---TermName
|   |   |   |   |---"x"
|   |   |   |---TypeTree
|   |   |   |   |---
|   |   |   |---Literal
|   |   |   |   |---Constant
|   |   |   |   |   |---1
|   |   |---ValDef
|   |   |   |---Modifiers
|   |   |   |   |---
|   |   |   |---TermName
|   |   |   |   |---"y"
|   |   |   |---TypeTree
|   |   |   |   |---
|   |   |   |---Literal
|   |   |   |   |---Constant
|   |   |   |   |   |---2
|   |---Apply
|   |   |---Select
|   |   |   |---Ident
|   |   |   |   |---TermName
|   |   |   |   |   |---"x"
|   |   |   |---TermName
|   |   |   |   |---"$plus"
|   |   |---List
|   |   |   |---Ident
|   |   |   |   |---TermName
|   |   |   |   |   |---"y"
```

More usages like show or not show lines, change indent size, see [Example](https://github.com/Azard/Rattata/blob/master/src/main/scala/me/azard/rattata/Example.scala).
