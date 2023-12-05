import java.io.File

class Day5 (private val file: String) {

    fun returnResPart1() : Int {

        var lines = File(file).readLines()
        val seeds = lines[0].split(": ")[1].split(" ")
        lines = lines.subList(2, lines.size - 1)
        val lists = List(7) { listOf<String>() }.toMutableList()
        for (i in 0..7) {
            val n = lines.indexOfFirst { it == "\n" }
            lists[i] = lines.subList(0, n -1)
            lines = lines.subList(n + 1, lines.size - 1)
        } 



        return
    }
}