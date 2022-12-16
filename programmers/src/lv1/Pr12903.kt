package lv1

class Pr12903 {
    fun solution(s: String): String = s.substring(s.lastIndex / 2 .. s.length / 2)
}

fun main() {
    Pr12903().apply {
        println(solution("abcde"))
        println(solution("qwer"))
    }
}