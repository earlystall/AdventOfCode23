import kotlin.test.Test
import kotlin.test.assertEquals


class Testing {
    private val part1 : Day3 = Day3("src/main/resources/day3/part1test.txt")

    @Test
    fun testSample() {
        assertEquals(467835, part1.returnResPart2())
    }

}