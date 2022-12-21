package lv1

class Pr12918 {
    fun solution(s: String): Boolean = s.matches("\\d{4}|\\d{6}".toRegex())
}

fun main() {
    Pr12918().apply {
        println(solution("a234"))
        println(solution("1234"))
    }
}