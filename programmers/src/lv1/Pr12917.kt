package lv1

class Pr12917 {
    fun solution(s: String): String = s.toList().sortedDescending().joinToString("")
}

fun main() {
    Pr12917().apply {
        println(solution("Zbcdefg"))
    }
}