# Rattata

![Rattata](./Rattata.png)

Rattata is a Scala Abstract Syntax Tree(AST) pretty print tool.

Scala: 2.11.7

## Usage

Rattata hasn't publish to third-party library server, so use Rattata at local or reference from GitHub in `build.sbt`.

### Local use
```
> git clone https://github.com/Azard/Rattata.git
> cd Rattata
> sbt publish-local
```

Add `libraryDependencies += "me.azard" %%    "rattata"  % "1.0.0"` to `build.sbt`

Now can `import me.azard.rattata.Rattata`

### Reference from GitHub

See ["How can sbt pull dependency artifacts from git?" - StackOverflow](http://stackoverflow.com/questions/7550376/how-can-sbt-pull-dependency-artifacts-from-git).

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

* `Rattata.setTabSize(2).pprintAST(exp)` to change indent size.
* `Rattata.setShowLine(false).pprintAST(exp)` to remove lines.
* `Rattata.setTabSize(2).setShowLine(false).pprintAST(exp)` or setting at same time.
