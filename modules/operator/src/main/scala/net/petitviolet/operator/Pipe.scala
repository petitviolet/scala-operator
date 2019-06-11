package net.petitviolet.operator

import scala.util.chaining.scalaUtilChainingOps

final class Pipe[A] private[operator](private val value: A) extends AnyVal { self =>
  def |>[B](f: A => B): B = pipe(f)
  def pipe[B](f: A => B): B = scalaUtilChainingOps(value).pipe(f)

  def tap(f: A => Unit): A = scalaUtilChainingOps(value).tap(f)
  def <|(f: A => Unit): A = tap(f)
  def |>>(f: A => Unit): A = tap(f)
}
