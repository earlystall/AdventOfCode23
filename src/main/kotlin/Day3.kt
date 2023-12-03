import java.io.File

//Not my proudest code

class Day3 (private val file: String) {

    private val symbolMapping = mutableMapOf<Int, MutableList<Int>>()
    private var checking = false
    private var start = 0
    private var total = 0
    private var str = ""
    private val lines = File(file).readLines()

    private val gearMapping = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()

    fun returnResPart1() : Int {

        for (i in lines.indices) {
            for (j in 0..<lines[i].length) {
                if (!lines[i][j].isDigit() && lines[i][j] != '.') {
                    if (symbolMapping.contains(i)) {
                        symbolMapping[i]?.add(j)
                    } else {
                        symbolMapping[i] = mutableListOf(j)
                    }
                }
            }
        }
        for (i in lines.indices) {
            for (j in 0..lines[i].length) {
                if (j == lines[i].length) {
                    if (checking) {
                        checking = false
                        if (symbolMapping.contains(i-1)) {
                            if (symbolMapping[i-1]?.any { it in (start - 1)..< j } == true) {
                                total += str.toInt()
                                continue
                            }
                        }
                        if (symbolMapping.contains(i+1)) {
                            if (symbolMapping[i+1]?.any { it in (start - 1)..< j } == true) {
                                total += str.toInt()
                                continue
                            }
                        }
                        if (symbolMapping.contains(i)) {
                            if (symbolMapping[i]?.contains(start -1) == true) {
                                total += str.toInt()
                                continue
                            }
                        }
                        continue
                    } else {
                        continue
                    }
                }
                if (!checking) {
                    if (lines[i][j].isDigit()) {
                        checking = true
                        start = j
                        str = lines[i][j].toString()
                    } else {
                        continue
                    }
                } else {
                    if (lines[i][j].isDigit()) {
                        str += lines[i][j]
                    } else {
                        checking = false
                        if (symbolMapping.contains(i-1)) {
                            if (symbolMapping[i-1]?.any { it in (start - 1)..j } == true) {
                                total += str.toInt()
                                continue
                            }
                        }
                        if (symbolMapping.contains(i+1)) {
                            if (symbolMapping[i+1]?.any { it in (start - 1)..j } == true) {
                                total += str.toInt()
                                continue
                            }
                        }
                        if (symbolMapping.contains(i)) {
                            if (symbolMapping[i]?.contains(start -1) == true || symbolMapping[i]?.contains(j) == true) {
                                total += str.toInt()
                                continue
                            }
                        }
                    }
                }
            }
        }
        return total
    }

    fun returnResPart2() : Int {

        for (i in lines.indices) {
            for (j in 0..<lines[i].length) {
                if (lines[i][j] == '*') {
                    gearMapping[Pair(i, j)] = mutableListOf()
                }
            }
        }
        for (i in lines.indices) {
            for (j in 0..lines[i].length) {
                if (j == lines[i].length) {
                    if (checking) {
                        checking = false
                        for (k in start - 1..<j) {
                            if (gearMapping.contains(Pair(i-1, k))) {
                                gearMapping[Pair(i-1, k)]?.add(str.toInt())
                            }
                            if (gearMapping.contains(Pair(i+1, k))) {
                                gearMapping[Pair(i+1, k)]?.add(str.toInt())
                            }
                        }
                        if (gearMapping.contains(Pair(i, start-1))) {
                            gearMapping[Pair(i, start - 1)]?.add(str.toInt())
                        }
                        continue
                    } else {
                        continue
                    }
                }
                if (!checking) {
                    if (lines[i][j].isDigit()) {
                        checking = true
                        start = j
                        str = lines[i][j].toString()
                    } else {
                        continue
                    }
                } else {
                    if (lines[i][j].isDigit()) {
                        str += lines[i][j]
                    } else {
                        checking = false
                        for (k in start - 1..j) {
                            if (gearMapping.contains(Pair(i-1, k))) {
                                gearMapping[Pair(i-1, k)]?.add(str.toInt())
                            }
                            if (gearMapping.contains(Pair(i+1, k))) {
                                gearMapping[Pair(i+1, k)]?.add(str.toInt())
                            }
                        }
                        if (gearMapping.contains(Pair(i, start-1))) {
                            gearMapping[Pair(i, start - 1)]?.add(str.toInt())
                        }
                        if (gearMapping.contains(Pair(i, j))) {
                            gearMapping[Pair(i, j)]?.add(str.toInt())
                        }
                    }
                }
            }
        }
        for (nums in gearMapping.values) {
            if (nums.size == 2) {
                total += nums[0] * nums[1]
            }
        }
        return total
    }
}


