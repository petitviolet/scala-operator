package net.petitviolet.operator

class stringSpec extends TestBase {
  "snakize" should "return snake_case string" in {
    val target = "abcDefGhi_klm"
    val expected = "abc_def_ghi_klm"
    target.snakenize shouldBe expected
  }

  "camelize" should "return camelCase string" in {
    val target = "abc_defGhi_klm__OPQ"
    val expected = "abcDefGhiKlm_OPQ"
    target.camelize shouldBe expected
  }
}
