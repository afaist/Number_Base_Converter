import java.math.BigDecimal
import java.math.RoundingMode

fun main() = println(BigDecimal(readLine()!!).setScale(readLine()!!.toInt(), RoundingMode.HALF_DOWN))