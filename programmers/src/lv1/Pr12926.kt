package lv1

class Pr12926 {
    fun solution(s: String, n: Int): String =
        s.map {
            when {
                it.isLowerCase() -> 'a' + (it + n - 'a') % 26
                it.isUpperCase() -> 'A' + (it + n - 'A') % 26
                else -> it
            }
        }.joinToString("")
}

fun main() {
    Pr12926().apply {
        println(solution("AB", 1))
        println(solution("z", 1))
        println(solution("a B z", 4))
    }
}