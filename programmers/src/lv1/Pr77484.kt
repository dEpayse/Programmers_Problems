package lv1

import printIntArray

class Pr77484 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray =
        listOf(
            lottos.intersect(win_nums.toSet()).count() + lottos.count { it == 0 },
            lottos.intersect(win_nums.toSet()).count()
        ).map {
            when {
                it <= 1 -> 6
                else -> 6 - it + 1
            }
        }.toIntArray()
}

fun main() {
    Pr77484().apply {
        printIntArray(
            solution(
                intArrayOf(44, 1, 0, 0, 31, 25),
                intArrayOf(31, 10, 45, 1, 6, 19)
            )
        )
        printIntArray(
            solution(
                intArrayOf(0, 0, 0, 0, 0, 0),
                intArrayOf(38, 19, 20, 40, 15, 25)
            )
        )
        printIntArray(
            solution(
                intArrayOf(45, 4, 35, 20, 3, 9),
                intArrayOf(20, 9, 3, 45, 4, 35)
            )
        )
    }
}