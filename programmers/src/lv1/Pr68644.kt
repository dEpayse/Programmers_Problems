package lv1

import printIntArray

class Pr68644 {
    fun solution(numbers: IntArray): IntArray =
        mutableSetOf<Int>().apply {
            (0 until numbers.size -1).forEach {first ->
                (first + 1 until numbers.size).forEach { second ->
                    add(numbers[first] + numbers[second])
                }
            }
        }.sorted().toIntArray()
}

fun main() {
    Pr68644().apply {
        printIntArray(solution(intArrayOf(2, 1, 3, 4, 1)))
        printIntArray(solution(intArrayOf(5, 0, 2, 7)))
    }
}