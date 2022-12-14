package lv1

class Pr12912 {
    fun solution(a: Int, b: Int): Long {
        val max = a.coerceAtLeast(b)
        val min = a.coerceAtMost(b)
        return (min.toLong()..max.toLong()).sum()
    }
}

fun main() {
    Pr12912().apply {
        println(solution(3,5))
        println(solution(3,3))
        println(solution(5,3))
    }
}