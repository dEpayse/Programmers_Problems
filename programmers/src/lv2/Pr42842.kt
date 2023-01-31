package lv2

import kotlin.math.pow
import kotlin.math.sqrt

class Pr42842 {
    fun solution(brown: Int, yellow: Int): IntArray {
        val twiceA = 4
        val squareB = brown + 4
        val rootPerfectSquare = sqrt(squareB.toFloat().pow(2) - 16 * (brown + yellow)).toInt()
        return intArrayOf(
            (squareB + rootPerfectSquare) / twiceA,
            (squareB - rootPerfectSquare) / twiceA
        )
    }
}

fun main() {
    Pr42842().apply {
        println(solution(10, 2).contentToString())
        println(solution(8, 1).contentToString())
        println(solution(24, 24).contentToString())
    }
}