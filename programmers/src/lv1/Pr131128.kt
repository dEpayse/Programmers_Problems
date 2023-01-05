package lv1

import kotlin.math.min

class Pr131128 {
    fun solution(X: String, Y: String): String =
        X.toSortedSet().intersect(Y.toSet()).reversed().joinToString("") {
            CharArray(
                min(X.count { it1 -> it1 == it }, Y.count { it1 -> it1 == it })
            ) { _ -> it }.joinToString("")
        }.let {
            if (it.isEmpty()) "-1"
            else if ("0+".toRegex().matches(it)) it.toInt().toString()
            else it
        }
}

fun main() {
    Pr131128().apply {
        println(solution("100", "2345"))
        println(solution("100", "203045"))
        println(solution("100", "123450"))
        println(solution("12321", "42531"))
        println(solution("5525", "1255"))
    }
}