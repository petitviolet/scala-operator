package net.petitviolet.operator

class longSpec extends TestBase {
  "isPositive" should "return true when positive" in {
    1L.isPositive shouldBe true
    0L.isPositive shouldBe false
    (-1L).isPositive shouldBe false
  }
  "isNegative" should "return true when negative" in {
    1L.isNegative shouldBe false
    0L.isNegative shouldBe false
    (-1L).isNegative shouldBe true
  }

  "isZero" should "return true when 0" in {
    1L.isZero shouldBe false
    0L.isZero shouldBe true
    (-1L).isZero shouldBe false
  }

  "++" should "increment int" in {
    1L.++ shouldBe 2L
  }

  "between" should "includes left and right value" in {
    10L.between(1L, 100L) shouldBe true
    10L.between(10L, 100L) shouldBe true
    10L.between(1L, 10L) shouldBe true

    10L.between(11L, 100L) shouldBe false
    10L.between(1L, 9L) shouldBe false
  }
}
