import java.io.File

class Day5 (file: String) {

    private var numbers = listOf<Long>()
    private var lines = File(file).readLines()
    fun returnResPart1() : Long {

        val res = List(8) { mutableListOf<Long>() }.toMutableList()
        res[0] = lines[0].split(": ")[1].split(" ").map { it.toLong() }.toMutableList()

        lines = lines.subList(2, lines.size)
        val lists = List(7) { listOf<String>() }.toMutableList()

        for (i in 0..6) {
            val n = lines.indexOfFirst { it == "" }
            if (n < 0) {
                lists[i] = lines
            } else {
                lists[i] = lines.subList(0, n)
                lines = lines.subList(n + 1, lines.size)
            }

        }


        for (i in 0..6) {
            for (j in 0..<res[0].size) {
                for (k in 1..<lists[i].size) {
                    numbers = lists[i][k].split(" ").map { it.toLong() }
                    if (res[i][j] in numbers[1]..<numbers[1] + numbers[2]) {
                        res[i+1].add(numbers[0] + res[i][j] - numbers[1])
                        break
                    }
                }
                if (res[i+1].size == j) {
                    res[i+1].add(res[i][j])
                }
            }
        }

        return res[7].min()
    }
}