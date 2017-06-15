package net.petitviolet.operator

class intSpec extends TestBase {
  "isPositive" should "return true when positive" in {
    1.isPositive shouldBe true
    0.isPositive shouldBe false
    (-1).isPositive shouldBe false
  }
  "isNegative" should "return true when negative" in {
    1.isNegative shouldBe false
    0.isNegative shouldBe false
    (-1).isNegative shouldBe true
  }

  "isZero" should "return true when 0" in {
    1.isZero shouldBe false
    0.isZero shouldBe true
    (-1).isZero shouldBe false
  }
}
