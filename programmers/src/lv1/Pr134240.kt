package lv1

class Pr134240 {
    fun solution(food: IntArray): String =
        (1..food.lastIndex)
            .map { idx ->
                CharArray(food[idx] / 2) { idx.digitToChar() }.joinToString("")
            }
            .filter { it.isNotEmpty() }
            .joinToString("")
            .let { "${it}0${it.reversed()}" }
}

fun main() {
    Pr134240().apply {
        println(solution(intArrayOf(1, 3, 4, 6)))
        println(solution(intArrayOf(1, 7, 1, 2)))
    }
}