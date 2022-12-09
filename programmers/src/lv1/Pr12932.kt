package lv1

class Pr12932 {
    fun solution(n: Long): IntArray = n.toString().reversed().map { it.digitToInt() }.toIntArray()
}

fun main() {
    Pr12932().apply {
        println(solution(12345).toList())
    }
}