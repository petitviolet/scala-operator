package net.petitviolet

import scala.language.implicitConversions

package object operator {
  implicit def toBoolOps(b: Boolean): BoolOps = new BoolOps(b)
  implicit def toPipe[A](a: A): Pipe[A] = new Pipe[A](a)
  implicit def toIntOps(i: Int): IntOps = new IntOps(i)
  implicit def toLongOps(i: Long): LongOps = new LongOps(i)
  implicit def toCompare[A](a: A): RichBoolOps[A] = new RichBoolOps[A](a)
  implicit def toStringOps(s: String): StringOperator = new StringOperator(s)
  implicit def toFunctionOps[A, B](f: A => B): FunctionOps[A, B] = new FunctionOps[A, B](f)
  implicit def toDoubleOps(d: Double): DoubleOps = new DoubleOps(d)
}
