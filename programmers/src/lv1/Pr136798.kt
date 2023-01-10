package lv1

import kotlin.math.sqrt

class Pr136798 {
    fun solution(number: Int, limit: Int, power: Int): Int =
        (1..number)
            .map {
                val newPower = primeNumCnt(it)
                if(newPower > limit) power
                else newPower
            }
            .sum()

    private fun primeNumCnt(n: Int): Int {
        var cnt = 0
        (1..sqrt(n.toFloat()).toInt()).forEach {
            if(n % it == 0) {
                if(it.toFloat() == sqrt(n.toFloat())) {
                    cnt++
                }
                else cnt += 2
            }
        }
        return cnt
    }
}

fun main() {
    Pr136798().apply {
        println(solution(5, 3, 2))
        println(solution(10, 3, 2))
    }
}