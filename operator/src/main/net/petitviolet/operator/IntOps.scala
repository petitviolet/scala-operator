package net.petitviolet.operator

final class IntOps private[operator](val i: Int) extends AnyVal {
  def isPositive: Boolean = i > 0
  def isNegative: Boolean = i < 0
  def isZero: Boolean = i == 0
}
