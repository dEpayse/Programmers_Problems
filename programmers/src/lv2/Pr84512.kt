package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
class Pr84512 {
    fun solution(word: String): Int {
        var answer = 0
        val enableWords = arrayOf('A', 'E', 'I', 'O', 'U')
        word.forEachIndexed { idx, ch ->
            val formalWordsCnt = (0 until 5- idx).sumOf {
                Math.pow(5.toDouble(), it.toDouble()).toInt() * enableWords.indexOf(ch)
            }
            answer += 1 + formalWordsCnt
        }
        return answer
    }
}

fun main() {
    Pr84512().apply {
        println(solution("AAAAE"))
        println(solution("AAAE"))
        println(solution("I"))
        println(solution("EIO"))
    }
}