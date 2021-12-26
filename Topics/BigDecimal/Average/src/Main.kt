import java.math.RoundingMode

const val THREE = "3"
fun main() = Array(THREE.toInt()) { readLine()!!.toBigDecimal() }.run {
    println(this.sumOf { it }.setScale(0, RoundingMode.DOWN) / THREE.toBigDecimal())
}