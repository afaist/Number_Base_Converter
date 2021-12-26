package converter

import java.math.BigDecimal
import java.math.BigInteger

const val TEN = "10"

object Converter {
    fun convertFromDecimal(source: String, toBase: String): String {
        if (toBase == TEN) {
            return source
        }
        return if (source.contains(".")) {
            val intPart = source.substring(0, source.indexOf('.'))
            val int = intPart.toBigInteger().toString(toBase.toInt())
            val fr = source.substring(source.indexOf('.') + 1)
            var remains = ("0.$fr").toBigDecimal()
            val fraction = StringBuilder()
            val base = toBase.toBigDecimal()
            var n = 0

            while (n < 5) {
                val multi = remains * base
                fraction.append(multi.toBigInteger().toString(toBase.toInt()))
                remains = multi.remainder(BigDecimal.ONE)
                n++
            }
            "$int.$fraction"
        } else {
            BigInteger(source).toString(toBase.toInt())
        }
    }

    /**
     * Convert number to decimal
     *
     * @param source
     * @param fromBase
     * @return decimal number as string
     */
    fun convertToDecimal(source: String, fromBase: String): String {
        if (fromBase == TEN) {
            return source
        }
        return if (source.contains('.')) {
            val intPart = source.substring(0, source.indexOf('.'))
            val int = intPart.toBigInteger(fromBase.toInt()).toBigDecimal()
            val remains = source.substring(source.indexOf('.') + 1)
            var fraction = BigDecimal("0.0").setScale(5)
            val base = fromBase.toBigDecimal()
            for (c in remains.reversed()) {
                fraction += c.toString().toBigInteger(fromBase.toInt()).toBigDecimal()
                fraction /= base
            }
            "${int + fraction}"
        } else {
            source.toBigInteger(fromBase.toInt()).toString()
        }
    }
}