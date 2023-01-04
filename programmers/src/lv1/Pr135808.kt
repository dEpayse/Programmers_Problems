package lv1

class Pr135808 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer = 0
        val apples = score.sorted()
        (apples.size-m downTo 0 step m).forEach {
            answer += apples[it] * m
        }
        return answer
    }
}

fun main() {
    Pr135808().apply {
        println(solution(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)))
        println(solution(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))
    }
}