package net.petitviolet.operator

object Example extends App {

  assert(true and true)
  assert(true or false)
  assert(true nand false)
  assert(true xor false)
  assert(false nor false)
  assert(not(false))

  assert(10.isPositive)
  assert(-10 isNegative)
  0.fold { _.isZero } { i => s"$i is zero" } { i => s"$i is not zero" } |> println
  1.isZero.fold("1 is zero")("1 is not zero") |> println

  // simulate Java class
  private class Config(var port: Int = 0, var host: String = "") {
    def validate: Boolean = port.isPositive and port > 1023
    def +=(i: Int) : Unit = port += i
  }
  private val show: Config => String = h => s"${h.host}:${h.port}"
  private val conf = new Config()
    .|>> { _.port = 1023 }
    .|>> { _.host = "localhost"}
  conf |> show |> println
  (conf.validate is false) |> println
  (conf |>> { _ += 10 } |> { _.port } is 1023 + 10) |> println

  println("abc_def".camelize)
  println("abcDef".snakenize)
}

