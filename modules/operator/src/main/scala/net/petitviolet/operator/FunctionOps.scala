package net.petitviolet.operator

final class FunctionOps[A, B](private val f: A => B) extends AnyVal {
  def each(as: Iterable[A]): Iterable[B] = as map f
}
