import kotlin.test.Test
import kotlin.test.assertEquals


class Testing {
    private val part1 : Day5 = Day5("src/main/resources/day5/test.txt")

    @Test
    fun testSample() {
        assertEquals(35, part1.returnResPart1())
        //assertEquals(30, part1.returnResPart2())
    }

}