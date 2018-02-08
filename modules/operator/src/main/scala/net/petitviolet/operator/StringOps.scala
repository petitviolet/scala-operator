package net.petitviolet.operator

private object StringOps {
  private val spacesPattern = "[-\\s]".r
  private val firstPattern = "([A-Z]+)([A-Z][a-z])".r
  private val secondPattern = "([a-z\\d])([A-Z])".r
  private val replacementPattern = "$1_$2"
}

class StringOps(val word: String) extends AnyVal {

  import StringOps._

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
