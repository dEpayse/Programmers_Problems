package lv1

import printIntArray

class Pr42889 {
    fun solution(N: Int, stages: IntArray): IntArray =
        (1..N)
            .mapIndexed { idx, i ->
                Pair(idx, stages.count { it == i }.toDouble() / stages.count { it >= i })
            }
            .sortedWith { (idx1, rate1), (idx2, rate2) ->
                if (rate1 > rate2) -1
                else if (rate1 < rate2) 1
                else idx1.compareTo(idx2)
            }
            .map { (idx, _) -> idx + 1 }
            .toIntArray()
}

fun main() {
    Pr42889().apply {
        printIntArray(solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)))
        printIntArray(solution(4, intArrayOf(4, 4, 4, 4, 4)))
    }
}