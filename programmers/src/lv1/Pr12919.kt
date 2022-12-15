package lv1

import printIntArray

class Pr12019 {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val answer = arr.filter { it % divisor == 0 }.sorted()
        if(answer.isEmpty()) return intArrayOf(-1)
        return answer.toIntArray()
    }
}

fun main() {
    Pr12019().apply {
        printIntArray(solution(intArrayOf(5, 9, 7, 10), 5))
        printIntArray(solution(intArrayOf(2, 36, 1, 3), 1))
        printIntArray(solution(intArrayOf(3, 2, 6), 10))
    }
}