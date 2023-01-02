package lv1

class Pr147355 {
    fun solution(t: String, p: String): Int =
        t.windowed(p.length).count {
            it.toLong() <= p.toLong()
        }
}

fun main() {
    Pr147355().apply {
        println(solution("3141592", "271"))
        println(solution("500220839878", "7"))
        println(solution("10203", "15"))
    }
}