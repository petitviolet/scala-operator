package net.petitviolet.operator

class functionSpec extends TestBase {
  "each" should "apply function to each elements" in {
    val f: String => Int = _.length
    f.each(List("a", "bb", "ccc", "d")) shouldBe List(1, 2, 3, 1)
    f.each(Nil) shouldBe Nil
  }
}
