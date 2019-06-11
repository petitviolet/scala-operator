package net.petitviolet.operator

import scala.util.matching.Regex

private object internalStringOps {
  val spacesPattern: Regex = "[-\\s]".r
  val firstPattern: Regex = "([A-Z]+)([A-Z][a-z])".r
  val secondPattern: Regex = "([a-z\\d])([A-Z])".r
  val replacementPattern: String = "$1_$2"
}

class StringOperator(private val word: String) extends AnyVal {

  import internalStringOps._

  def snakenize: String = {
    spacesPattern
      .replaceAllIn(secondPattern.replaceAllIn(
        firstPattern.replaceAllIn(word, replacementPattern),
        replacementPattern
      ),
        "_")
      .toLowerCase
  }

  def camelize: String = {
    @scala.annotation.tailrec
    def loop(left: List[Char] = Nil, right: List[Char] = word.toList): List[Char] =
      right match {
        case '_' :: c :: rest => loop(c.toUpper :: left, rest)
        case '_' :: Nil => left
        case c :: rest => loop(c :: left, rest)
        case Nil => left
      }

    loop().reverse.mkString
  }
}
