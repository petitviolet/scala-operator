package net.petitviolet.operator

final class LongOps private[operator](val l: Long) extends AnyVal {
  def isPositive: Boolean = l > 0

  def isNegative: Boolean = l < 0

  def isZero: Boolean = l == 0

  def ++ : Long = l + 1L

  def between(min: Long, max: Long): Boolean = min <= l && l <= max
}
