import java.io.File

class Day6 (file: String) {

    private val lines = File(file).readLines()

    fun returnResPart1() : Int {
        val time = lines[0].split(":")[1].replace(Regex("\\s+"), ",").split(",").filter { it != "" }.map { it.toInt() }
        val distance = lines[1].split(":")[1].replace(Regex("\\s+"), ",").split(",").filter { it != "" }.map { it.toInt() }

        return time.zip(distance) {a, b -> numberOfWays(a ,b) } .fold(1) {total, each -> total * each}
    }

    fun numberOfWays(time : Int, distance : Int) : Int{
        return (1..time).count { (time - it) * it > distance }
    }

    fun returnResPart2() : Long {
        val time = lines[0].split(":")[1].replace(Regex("\\s+"), "").toLong()
        val distance = lines[1].split(":")[1].replace(Regex("\\s+"), "").toLong()
        return (time downTo 1).first {(time - it) * it > distance} - (1..time).first { (time - it) * it > distance } + 1

    }
}