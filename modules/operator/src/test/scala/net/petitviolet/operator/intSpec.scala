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

  "++" should "increment int" in {
    1.++ shouldBe 2
  }

  "between" should "includes left and right value" in {
    10.between(1, 100) shouldBe true
    10.between(10, 100) shouldBe true
    10.between(1, 10) shouldBe true

    10.between(11, 100) shouldBe false
    10.between(1, 9) shouldBe false
  }

  "times" should "generate Range object 1 to self" in {
    1.times.length shouldBe 1
    100.times.length shouldBe 100
    0.times.length shouldBe 0
    (-1).times.length shouldBe 0
  }

  "repeat" should "apply function specified times" in {
    10.repeat(0) { _ + 1 } shouldBe 10
    10.repeat(1) { _ * 2 } shouldBe 1024

    0.repeat(0) { _ + 1 } shouldBe 0
    (-1).repeat(0) { _ + 1 } shouldBe 0
  }
}
