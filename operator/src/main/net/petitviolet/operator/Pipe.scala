package net.petitviolet.operator

final class Pipe[A] private[operator](val value: A) extends AnyVal {
  def |>[B](f: A => B): B = f(value)
  def |>>(f: A => Unit): A = { f(value); value }
}
