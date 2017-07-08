package net.petitviolet.operator

class pipeSpec extends TestBase {

  "|>" should "apply function" in {
    "123" |> { _.length } shouldBe 3

    "abc" |> { _.reverse } |> { _.toUpperCase } |> { _ + "!"} |> { _.reverse } shouldBe "!ABC"

    val increment: Int => Int = _ + 1
    1 |> increment |> increment shouldBe 3
  }



  "|>>" should "apply function and return itself" in {
    "123" |>> { _.length } shouldBe "123"

    class X(var value: Int)

    (new X(0) |>> { _.value = 100 }).value shouldBe 100
  }

}
