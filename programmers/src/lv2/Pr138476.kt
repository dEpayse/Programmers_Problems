package lv2

class Pr138476 {
    fun solution(k: Int, tangerine: IntArray): Int {
        var kCnt = 0
        var answer = 0
        val sortedDescendingByCnt = tangerine
            .groupBy { it }
            .map { it.value.size }
            .sortedDescending()
        sortedDescendingByCnt.forEach {
            kCnt += it
            answer++
            if (kCnt >= k) return answer
        }
        return 0
    }
}

fun main() {
    Pr138476().apply {
        println(
            solution(
                6,
                intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
            )
        )
        println(
            solution(
                4,
                intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
            )
        )
        println(
            solution(
                2,
                intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)
            )
        )
    }
}