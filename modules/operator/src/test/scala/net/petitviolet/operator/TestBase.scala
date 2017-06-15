package net.petitviolet.operator

import org.scalatest.concurrent.{ ScalaFutures, TimeLimits }
import org.scalatest.time._
import org.scalatest.{ FlatSpec, GivenWhenThen, Matchers }

import scala.concurrent.ExecutionContext

trait TestBase extends FlatSpec with Matchers with GivenWhenThen with TimeLimits with ScalaFutures {
  protected implicit val ec: ExecutionContext =
    scala.concurrent.ExecutionContext.Implicits.global
  implicit override val patienceConfig =
    PatienceConfig(timeout = Span(2, Seconds), interval = Span(20, Millis))
}
