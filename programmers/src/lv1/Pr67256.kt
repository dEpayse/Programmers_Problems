package lv1

import kotlin.math.abs

class Pr67256 {
    fun solution(numbers: IntArray, hand: String): String {
        var curLeftPos = 10
        var curRightPos = 12
        return numbers.map {
            when (it) {
                1, 4, 7 -> {
                    curLeftPos = it
                    'L'
                }
                3, 6, 9 -> {
                    curRightPos = it
                    'R'
                }
                else -> {
                    val selectedFinger = getProperFinger(
                        getTransformedInt(it),
                        getTransformedInt(curLeftPos),
                        getTransformedInt(curRightPos),
                        hand
                    )
                    if (selectedFinger == 'L') curLeftPos = it
                    else curRightPos = it
                    selectedFinger
                }
            }
        }.joinToString("")
    }

    private fun getProperFinger(destination: Int, left: Int, right: Int, hand: String): Char {
        val leftDistance = (abs(destination - left) / 3) + (abs(destination - left) % 3)
        val rightDistance = (abs(destination - right) / 3) + (abs(destination - right) % 3)
        return when {
            leftDistance < rightDistance -> 'L'
            leftDistance > rightDistance -> 'R'
            else -> {
                if (hand == "left") 'L'
                else 'R'
            }
        }
    }

    private fun getTransformedInt(n: Int): Int = if (n == 0) 11 else n
}

fun main() {
    Pr67256().apply {
        println(solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
        println(solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left"))
        println(solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right"))
    }
}