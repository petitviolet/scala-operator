package net.petitviolet.operator

import scala.math.BigDecimal.RoundingMode

final class DoubleOps private[operator](private val d: Double) extends AnyVal {
  def round(scale: Int): Double = {
    BigDecimal(d).setScale(scale, RoundingMode.HALF_UP).doubleValue
  }
}
