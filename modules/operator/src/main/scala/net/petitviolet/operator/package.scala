package net.petitviolet

import scala.language.implicitConversions

package object operator {
  implicit def toBoolOps(b: Boolean): BoolOps = new BoolOps(b)
  implicit def toPipe[A](a: A): Pipe[A] = new Pipe[A](a)
  implicit def toIntOps(i: Int): IntOps = new IntOps(i)
  implicit def toCompare[A](a: A): RichBoolOps[A] = new RichBoolOps[A](a)
}
