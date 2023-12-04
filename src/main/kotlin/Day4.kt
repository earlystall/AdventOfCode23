import java.io.File

class Day4 (private val file: String){

    private val list = listOf(0,1,2,4,8,16,32,64,128,256,512)
    private val coolMapping = mutableMapOf<Int, Int>()


    fun returnResPart1() : Int {
        return File(file).readLines().fold(0) { total, line -> total + calcCardValue(line)}
    }

    private fun calcCardValue(string: String) : Int {
        val winningNumbers = string.replace("  ", " ").split(" | ")[0].split(": ")[1].split(" ")
        return list[string.replace("  ", " ").split(" | ")[1].split(" ").count { it in winningNumbers }]
    }

    fun returnResPart2() : Int {
        val lines = File(file).readLines()
        for (i in lines.indices) {
            if (!coolMapping.contains(i)) {
                coolMapping[i] = 1
            }
            val winningNumbers = lines[i].replace("  ", " ").split(" | ")[0].split(": ")[1].split(" ")
            val count = lines[i].replace("  ", " ").split(" | ")[1].split(" ").count { it in winningNumbers }
            for (j in i + 1..i + count) {
                if (coolMapping.contains(j)) {
                    coolMapping[j] = coolMapping[j]!! + coolMapping[i]!!
                } else {
                    coolMapping[j] = 1 + coolMapping[i]!!
                }
            }
        }
        return coolMapping.values.sum()
    }

}