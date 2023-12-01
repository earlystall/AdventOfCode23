import java.io.File

class Day1(val file: String) {

    fun returnRes() : Int {
        return File(file).readLines().fold(0) {total, line -> total + findBothDigits(line)}
    }

    fun findBothDigits(str: String) : Int {
        return (10 * findLeftDigit(str) + findRightDigit(str))
    }

    fun findLeftDigit(str: String) : Int {
        return str.first { it.isDigit() }.digitToInt()
    }

    fun findRightDigit(str: String) : Int {
        return str.reversed().first { it.isDigit() }.digitToInt()
    }
}