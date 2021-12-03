package day1

import java.io.File
import java.util.*

fun main() {
    partOne()
    partTwo()
}

fun partOne() {
    var current = 0
    var increases = 0

    File("src/main/kotlin/day1/input.txt").readLines().forEach{
        if (current != 0 && current < it.toInt()) {
            increases++
        }
        current = it.toInt()
    }
    println(increases)
}

fun partTwo() {
    val queueA: Queue<Int> = LinkedList<Int>()
    val queueB: Queue<Int> = LinkedList<Int>()
    var increases = 0

    File("src/main/kotlin/day1/input.txt").readLines().forEachIndexed{ index, it ->
        val current = it.toInt()

        if (index < 3) {
            queueA.add(current)
            return@forEachIndexed
        }

        // Bit ugly but it'll do
        queueB.clear()
        queueB.addAll(queueA.asIterable())

        queueA.remove()
        queueA.add(current)

        val queueASum = queueA.asIterable().sum()
        val queueBSum = queueB.asIterable().sum()

        if (queueB.size == 3 && (queueASum > queueBSum)) {
            increases++
        }
    }
    print(increases)
}