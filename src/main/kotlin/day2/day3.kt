package day2

import java.io.File

fun main() {
    partOne()
    partTwo()
}

fun partOne() {
    var horiz = 0
    var depth = 0

    File("src/main/kotlin/day2/input.txt").readLines().forEach{
        val instructions = it.splitToSequence(" ")

        when(instructions.first().lowercase()) {
            "forward" -> horiz += instructions.last().toInt()
            "up" -> depth -= instructions.last().toInt()
            "down" -> depth += instructions.last().toInt()
        }
    }
    println(horiz * depth)
}

fun partTwo() {
    var horiz = 0
    var depth = 0
    var aim = 0

    File("src/main/kotlin/day2/input.txt").readLines().forEach{
        val instructions = it.splitToSequence(" ")

        when(instructions.first().lowercase()) {
            "forward" -> {
                horiz += instructions.last().toInt()
                depth += (instructions.last().toInt() * aim)
            }
            "up" -> aim -= instructions.last().toInt()
            "down" -> aim += instructions.last().toInt()
        }
    }
    println(horiz * depth)
}