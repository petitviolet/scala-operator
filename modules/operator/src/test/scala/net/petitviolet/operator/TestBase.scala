package net.petitviolet.operator

import org.scalatest.time._
import org.scalatest._
import flatspec._
import matchers._

import scala.concurrent.ExecutionContext

trait TestBase extends AsyncFlatSpec with should.Matchers {
}
