package lv2

import kotlin.math.log2

class Pr12985 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = log2(n.toDouble()).toInt()
        var tempRange = 1..n
        while ((a in tempRange.halfFront() && b in tempRange.halfFront()) || (a in tempRange.halfBack() && b in tempRange.halfBack())) {
            tempRange =
                if (a in tempRange.halfFront()) tempRange.halfFront()
                else tempRange.halfBack()
            if (answer == 1) break
            answer--
        }
        return answer
    }

    private fun IntRange.halfFront(): IntRange = first..(first + last) / 2
    private fun IntRange.halfBack(): IntRange = (first + last) / 2 + 1..last
}

fun main() {
    Pr12985().apply {
//        println(solution(8, 4, 7))
//        println(solution(8, 4, 1))
//        println(solution(16,1,16))
        println(solution(16,10,12))
    }
}