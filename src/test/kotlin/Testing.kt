import kotlin.test.Test
import kotlin.test.assertEquals


class Testing {
    private val part1 : Day2 = Day2("src/main/resources/day2/part1test.txt")

    @Test
    fun testSample() {
        assertEquals(2286, part1.returnRes())
    }

}