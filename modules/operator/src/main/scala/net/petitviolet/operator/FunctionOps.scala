package net.petitviolet.operator

final class FunctionOps[A, B](val f: A => B) extends AnyVal {
  def each(as: TraversableOnce[A]): TraversableOnce[B] = as map f
}
