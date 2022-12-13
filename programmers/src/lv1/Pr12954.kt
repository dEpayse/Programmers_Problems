package lv1

class Pr12954 {
    fun solution(x: Int, n: Int): LongArray = LongArray(n) { x.toLong() + it * x.toLong()}
}

fun main() {
    Pr12954().apply {
        println(solution(2,5).toList())
        println(solution(4,3).toList())
        println(solution(-4,2).toList())
    }
}