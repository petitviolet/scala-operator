package net.petitviolet.operator

final class BoolOps private[operator](val a: Boolean) extends AnyVal {
  def and(b: Boolean): Boolean = a && b

  def or(b: Boolean): Boolean = a || b

  def xor(b: Boolean): Boolean = (a && !b) || (!a && b)

  def nor(b: Boolean): Boolean = !or(b)

  def nand(b: Boolean): Boolean = !and(b)

  def fold[A](t: => A)(f: => A): A = if (a) t else f
}

object not {
  // not(true) == false
  def apply(b: Boolean): Boolean = !b
}

final class RichBoolOps[A] private[operator](val a: A) extends AnyVal {
  def is(b: A): Boolean = a == b
  def not(b: A): Boolean = !is(b)
  def <>(b: A): Boolean = not(b)
  def fold[B](f: A => Boolean)(ft: => A => B)(ff: => A => B): B =
    if (f(a)) ft(a) else ff(a)
}



