package lv1

import printIntArray

class Pr12935 {
    fun solution(arr: IntArray): IntArray {
        val answer = arr.toMutableList().apply { remove(arr.minOrNull()) }.toIntArray()
        if(answer.isEmpty()) return intArrayOf(-1)
        return answer
    }
}

fun main() {
    Pr12935().apply {
        printIntArray(solution(intArrayOf(4,3,2,1)))
        printIntArray(solution(intArrayOf(10)))
    }
}