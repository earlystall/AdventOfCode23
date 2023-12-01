import kotlin.test.Test
import kotlin.test.assertEquals


class Testing {
    private val part1 : Day1 = Day1("src/main/resources/day1/part1test.txt")
    private val part2 : Day1 = Day1("src/main/resources/day1/part2test.txt")

    @Test
    fun testSample() {
        assertEquals(142, part1.returnRes())
        assertEquals(281, part2.returnRes())
    }

}