package lv1

class Pr12947 {
    fun solution(x: Int): Boolean = x % x.toString().fold(0) { acc, c -> acc + c.digitToInt() } == 0
}

fun main() {
    Pr12947().apply {
        println(solution(10))
        println(solution(12))
        println(solution(11))
        println(solution(13))
    }
}