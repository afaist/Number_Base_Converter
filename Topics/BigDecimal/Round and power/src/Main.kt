import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val (power, mode) = IntArray(2) { readLine()!!.toInt() }
    println(BigDecimal(readLine()!!).setScale(mode, RoundingMode.FLOOR).pow(power))
}