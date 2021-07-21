package lv1

import kotlin.math.sqrt

fun main() {
    println(solution(13, 17))
    println(solution(24, 27))
}

fun solution(left: Int, right: Int): Int =
    (left..right).map{ num ->
        var divisorNum = 0
        for(i in 1..sqrt(num.toFloat()).toInt()){
            if (i.toFloat() == sqrt(num.toFloat())) divisorNum++
            if (num % i == 0) divisorNum += 2
        }
        when (divisorNum % 2) {
            0 -> num
            else ->  -num
        }
    }.sum()
