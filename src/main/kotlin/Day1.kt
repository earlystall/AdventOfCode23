import java.io.File

class Day1(private val file: String) {

    val mapping  = mapOf("one" to "one1one", "two" to "two2two", "three" to "three3three", "four" to "four4four",
        "five" to "five5five", "six" to "six6six", "seven" to "seven7seven", "eight" to "eight8eight", "nine" to "nine9nine")

    fun returnRes() : Int {
        return File(file).readLines().fold(0) {total, line -> total + findBothDigits(line)}
    }

    private fun findBothDigits(str: String) : Int {
        var string = str
        for (i in mapping.keys) {
            if (i in string) {
                string = string.replace(i, mapping[i]!!)
            }
        }
        return 10 * string.first { it.isDigit() }.digitToInt() + string.reversed().first { it.isDigit() }.digitToInt()
    }
}