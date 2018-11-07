package net.petitviolet.operator

final class Pipe[A] private[operator](val value: A) extends AnyVal { self =>
  def |>[B](f: A => B): B = andThen(f)
  def pipe[B](f: A => B): B = andThen(f)
  def andThen[B](f: A => B): B = f(value)
  def <|(f: A => Unit): A = tap(f)
  def tap(f: A => Unit): A = { f(value); value }
  def |>>(f: A => Unit): A = self <| f
}
