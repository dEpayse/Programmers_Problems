package lv1

import kotlin.math.sqrt

class Pr12977 {
    fun solution(nums: IntArray): Int {
        var answer = 0
        (0 until nums.size - 2).forEach { first ->
            (first + 1 until nums.size - 1).forEach { second ->
                (second + 1 until nums.size).forEach { third ->
                    if (isPrimeNumber(nums[first] + nums[second] + nums[third]))
                        answer++
                }
            }
        }
        return answer
    }

    private fun isPrimeNumber(num: Int): Boolean {
        if (num == 1) return false
        (2..sqrt(num.toDouble()).toInt()).forEach {
            if (num % it == 0) return false
        }
        return true
    }
}

fun main() {
    Pr12977().apply {
        println(solution(intArrayOf(1, 2, 3, 4)))
        println(solution(intArrayOf(1, 2, 7, 6, 4)))
    }
}