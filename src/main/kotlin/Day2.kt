import java.io.File

class Day2(private val file: String) {

    private val coolMapping = mutableMapOf("\\d* red" to 0,
        "\\d* green" to 0,
       "\\d* blue" to 0)


    fun returnRes() : Int {
        return File(file).readLines().fold(0) { total, line -> total + isGamePossible(line)}
    }

    private fun isGamePossible(str: String) : Int {

        for (i in coolMapping.keys) {
            coolMapping[i] = 0
            for (j in Regex(i).findAll(str)) {
                if (j.value.split(" ")[0].toInt() > coolMapping[i]!!) {
                    coolMapping[i] = j.value.split(" ")[0].toInt()
                }
            }
        }
        return coolMapping.values.fold(1) {total, each -> total * each}
    }
}