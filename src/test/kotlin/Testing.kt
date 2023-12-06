import kotlin.test.Test
import kotlin.test.assertEquals


class Testing {
    private val part1 = Day6("src/main/resources/day6/test.txt")

    @Test
    fun testSample() {
        //assertEquals(288, part1.returnResPart1())
        assertEquals(71503, part1.returnResPart2())
    }

}