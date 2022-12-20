package lv1

class Pr70128 {
    fun solution(a: IntArray, b: IntArray): Int =
        a.zip(b).sumOf { it.first * it.second }
}

fun main() {
    Pr70128().apply {
        println(solution(intArrayOf(1, 2, 3, 4), intArrayOf(-3, -1, 0, 2)))
        println(solution(intArrayOf(-1, 0, 1), intArrayOf(1, 0, -1)))
    }
}