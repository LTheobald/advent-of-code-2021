package day3

import java.io.File

fun main() {
    partOne()
    partTwo()
}

fun partOne() {
    var mostSignificantBits = mutableListOf<Pair<Int, Int>>()
    File("src/main/kotlin/day3/input.txt").readLines().forEach{
        // Init list on first line
        if (mostSignificantBits.isEmpty()) {
            mostSignificantBits = MutableList(it.length) { Pair(0, 0) }
        }

        it.forEachIndexed { index, curr ->
            var currPair = mostSignificantBits.get(index)
            when (curr) {
                '0' -> currPair = currPair.copy(first = currPair.first+1)
                '1' -> currPair = currPair.copy(second = currPair.second+1)
            }
            mostSignificantBits.set(index, currPair)
        }
    }

    var gamma = ""
    var epsilon = ""
    mostSignificantBits.forEachIndexed{index, curr ->
        if (curr.first >= curr.second) {
            // 0 was more common
            gamma += "0"
            epsilon += "1"
        } else {
            gamma += "1"
            epsilon += "0"
        }
    }
    println(gamma.toInt(2) * epsilon.toInt(2))
}

fun partTwo() {
    println("")
}