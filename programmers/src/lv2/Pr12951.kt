package lv2

class Pr12951 {
    fun solution(s: String): String =
        s.split(" ").joinToString(" ") {
            it.lowercase().mapIndexed { idx, c ->
                if(idx == 0 && c in 'a'..'z') c.uppercase()
                else c
            }.joinToString("")
        }
}

fun main() {
    Pr12951().apply {
        println(solution("3people unFollowed me"))
        println(solution("for the last week"))
    }
}