package lv1

import printIntArray

class Pr138477 {
    fun solution(k: Int, score: IntArray): IntArray {
        val hallOfFame = mutableListOf<Int>()
        return score.map {
            if(hallOfFame.size < k) hallOfFame.add(it)
            else if(it > hallOfFame.minOf { it1 -> it1 }) {
                hallOfFame.remove(hallOfFame.minOf { it1 -> it1 })
                hallOfFame.add(it)
            }
            hallOfFame.minOf { it1 -> it1 }
        }.toIntArray()
    }
}

fun main() {
    Pr138477().apply {
        printIntArray(solution(10, intArrayOf(100, 20, 150, 1, 100, 200)))
        printIntArray(solution(4, intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000)))
    }
}