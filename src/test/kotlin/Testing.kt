import kotlin.test.Test
import kotlin.test.assertEquals


class Testing {
    private val part1 : Day4 = Day4("src/main/resources/day4/test.txt")

    @Test
    fun testSample() {
        assertEquals(13, part1.returnResPart1())
        assertEquals(30, part1.returnResPart2())
    }

}