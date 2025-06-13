import org.junit.Test
import kotlin.test.assertEquals

class MainKtTest {

 @Test
 fun mastercardIsNotAvalible() {
  val result = feeCalculation("MasterCard", 200_000, 10_000, 0)
  assertEquals(-1, result)
 }

 @Test
 fun mastercardIsAvalible() {
  val result = feeCalculation("MasterCard", 15_000, 10_000, 0)
  assertEquals(0, result)
 }

 @Test
 fun visaIsAvalible() {
  val result = feeCalculation("Visa", 5_000, 0, 0)
  assertEquals(37, result)
 }

 @Test
 fun vkIsNotAvalible() {
  val result = feeCalculation("VKPay", 10_000, 55_000,0)
  assertEquals(-1, result)
 }

 @Test
 fun vkIsAvalible() {
  val result = feeCalculation("VKPay", 10_000, 50_000,0)
  assertEquals(0, result)
 }

 @Test
 fun transitionIsAvalible(){
  val result = feeCalculation("Мир")
  assertEquals(562, result)
 }

 @Test
 fun transitionIsNotAvalible(){
  val result = feeCalculation("Мир", 200_000, 50_000, 0)
  assertEquals(-1, result)
 }

 @Test
 fun main() {
  val result = feeCalculation("Мир")

  println(result)
  assertEquals(562, result)

 }

 @Test
 fun impossibleTransition() {
  val result = feeCalculation("Vasa")

  println(result)
  assertEquals(-1, result)
 }

 @Test
 fun minFeeVisa() {
  val result = feeCalculation("Visa", 2_000, 0, 0)
  assertEquals(35, result)
 }

 @Test
 fun maestroTooLittle() {
  val result = feeCalculation("MasterCard", 200, 0, 0)
  assertEquals(21, result)
 }

}