import kotlin.test.Test
import kotlin.test.assertEquals


class Testing {
    private val sample : Day1 = Day1("src/main/resources/day1test.txt")

    @Test
    fun testSample() {
        val expected = 142
        assertEquals(expected, sample.returnRes())
    }

}