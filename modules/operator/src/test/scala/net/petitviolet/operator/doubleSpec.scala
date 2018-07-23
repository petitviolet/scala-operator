package net.petitviolet.operator

class doubleSpec extends TestBase {
  "round" should "round a double number" in {
    (1.0d / 3.0d).round(3).toString shouldBe "0.333"
    (1.0d / 3.0d).round(6).toString shouldBe "0.333333"

    (10.0d / 3.0d).round(3).toString shouldBe "3.333"
    (10.0d / 4.0d).round(3).toString shouldBe "2.5"

    (9.0d / 4.0d).round(0).toString shouldBe "2.0"
    (10.0d / 4.0d).round(0).toString shouldBe "3.0"
  }
}
