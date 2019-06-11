package net.petitviolet.operator

final class IntOps private[operator](private val i: Int) extends AnyVal {
  def isPositive: Boolean = i > 0

  def isNegative: Boolean = i < 0

  def isZero: Boolean = i == 0

  def ++ : Int = i + 1

  def between(min: Int, max: Int): Boolean = min <= i && i <= max

  def times: Range = 1 to i

  def repeat[A](init: A)(f: A => A): A = {
    times.foldLeft(init) { (acc, _) => f(acc) }
  }
}
