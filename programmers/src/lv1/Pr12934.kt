package lv1

import kotlin.math.pow
import kotlin.math.sqrt

class Pr12934 {
    fun solution(n: Long): Long =
        if(sqrt(n.toDouble()) % 1 == 0.toDouble()) (sqrt(n.toDouble()) + 1).pow(2).toLong()
        else -1
}

fun main() {
    Pr12934().apply {
        println(solution(169))
        println(solution(3))
    }
}