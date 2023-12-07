import java.io.File

class Day7(file: String) {

    private val lines = File(file).readLines()

    fun returnResPart1() : Int{
        val cards = lines.map { it.split(" ")[0] }
        val bid = lines.map {it.split(" ")[1].toInt()}

        return findRank(cards).zip(bid) {a, b -> a * b}.fold(0) {total, each -> total + each}
    }

    fun findRank(cards: List<String>) : List<Int> {
        //Sort the lines first then group by their hand, the remaining is their rank

        val test = mutableListOf<Int>()
        var testMap: List<Int>
        for (i in cards.indices) {
            testMap = cards[i].groupingBy { it }.eachCount().values.toList()
            if (testMap.contains(5)) {
                test.add(7)
            } else if (testMap.contains(4)) {
                test.add(6)
            } else if (testMap.contains(3)) {
                if (testMap.contains(2)) {
                    test.add(5)
                } else {
                    test.add(4)
                }
            } else if (testMap.contains(2)) {
                if (testMap.)
            }
        }
    }
}