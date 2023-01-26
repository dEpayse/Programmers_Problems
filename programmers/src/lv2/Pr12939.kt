package lv2

class Pr12939 {
    fun solution(s: String): String =
        s.split(" ")
            .map { it.toInt() }
            .let { "${it.minOrNull()} ${it.maxOrNull()}" }
}

fun main() {
    Pr12939().apply {
        println(solution("1 2 3 4"))
        println(solution("-1 -2 -3 -4"))
        println(solution("-1 -1"))
    }
}