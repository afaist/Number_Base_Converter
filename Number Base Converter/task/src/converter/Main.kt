package converter

const val PROMPT = "Enter two numbers in format: {source base} {target base} (To quit type /exit) "

fun main() {
    while (true) {
        println(PROMPT)
        val input = readLine()!!
        if (input == "/exit") {
            break
        }
        val (source, target) = input.split(" ")
        while (true) {
            println("Enter number in base $source to convert to base $target (To go back type /back) ")
            val number = readLine()!!
            if (number == "/back") {
                break
            }
            val result = Converter.convertToDecimal(number, source).run {
                Converter.convertFromDecimal(this, target)
            }
            println("Conversion result: $result")
        }
        println()
    }
}