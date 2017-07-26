package net.petitviolet.operator

final class Pipe[A] private[operator](val value: A) extends AnyVal {
  final def |>[B](f: A => B): B = andThen(f)
  final def andThen[B](f: A => B): B = f(value)
  final def |>>(f: A => Unit): A = { f(value); value }
}
