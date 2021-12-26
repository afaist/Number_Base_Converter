import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val (start, percent) = Array<BigDecimal>(2) { readLine()!!.toBigDecimal() }
    val years = readLine()!!.toInt()
    val final = start * (BigDecimal.ONE + percent.setScale(2) / BigDecimal("100.0")).pow(years)
    println("Amount of money in the account: ${final.setScale(2, RoundingMode.CEILING)}")
}