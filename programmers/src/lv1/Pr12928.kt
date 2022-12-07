package lv1

import kotlin.math.sqrt

class Pr12928 {
    fun solution(n: Int): Int {
        var answer = 0
        val sqrtN = sqrt(n.toFloat())
        (1..sqrtN.toInt()).forEach {
            if(it.toFloat() == sqrtN) {
                answer += it
                return@forEach
            }
            if(n % it == 0) {
                answer += it
                answer += n / it
            }
        }
        return answer
    }
}

fun main() {
    Pr12928().apply {
        println(solution(12))
        println(solution(5))
    }
}