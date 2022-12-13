package lv1

class Pr12947 {
    fun solution(x: Int): Boolean = x % x.toString().map { it.digitToInt() }.reduce { acc, it -> acc + it } == 0
}

fun main() {
    Pr12947().apply {
        println(solution(10))
        println(solution(12))
        println(solution(11))
        println(solution(13))
    }
}