package net.petitviolet.operator

class boolSpec extends TestBase {
  "`and`" should "return true only both true" in {
    true and true shouldBe true
    true and false shouldBe false
    false and true shouldBe false
    false and false shouldBe false
  }

  "`or`" should "return true except both false" in {
    true or true shouldBe true
    true or false shouldBe true
    false or true shouldBe true
    false or false shouldBe false
  }

  "`xor`" should "return true left and right are not the same" in {
    true xor true shouldBe false
    true xor false shouldBe true
    false xor true shouldBe true
    false xor false shouldBe false
  }

  "`nor`" should "return true only both false" in {
    true nor true shouldBe false
    true nor false shouldBe false
    false nor true shouldBe false
    false nor false shouldBe true
  }

  "`nand`" should "return true except both true" in {
    true nand true shouldBe false
    true nand false shouldBe true
    false nand true shouldBe true
    false nand false shouldBe true
  }
  "`not`" should "return reversed boolean" in {
    net.petitviolet.operator.not(true) shouldBe false
    net.petitviolet.operator.not(false) shouldBe true
  }

  "fold" should "execute a function" in {
    true.fold[Int](1)(2) shouldBe 1
    false.fold[Int](1)(2) shouldBe 2
  }

  "rich-fold" should "execute a function" in {
    10.fold { _ == 10 } { _ * 2} { _ * 1 } shouldBe 20
    10.fold { _ != 10 } { _ * 2} { _ * 1 } shouldBe 10
  }

  "rich operator" should "return Boolean" in {
    1 is 1 shouldBe true
    1 is 2 shouldBe false
    // 1 is "hoge" => cannot compile

    1 not 1 shouldBe false
    1 not 2 shouldBe true

    1 <> 1 shouldBe false
    1 <> 2 shouldBe true
  }
}
