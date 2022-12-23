package lv1

class Pr12930 {
    fun solution(s: String): String = s.split(" ").joinToString(" ") {
        it.mapIndexed { idx, c -> if(idx % 2 == 0) c.uppercase() else c.lowercase() }.joinToString("")
    }
}

fun main() {
    Pr12930().apply {
        println(solution("try hello world"))
    }
}