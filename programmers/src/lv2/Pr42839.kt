package lv2

import java.util.LinkedList
import kotlin.math.sqrt

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
class Pr42839 {
    fun solution(numbers: String): Int =
        bruteForce(numbers).count { isPrime(it) }

    private fun bruteForce(numbers: String): Set<Int> {
        val result = mutableSetOf<Int>()
        fun bruteForce(
            numbers: String,
            depth: Int,
            visited: BooleanArray = BooleanArray(numbers.length) { false },
            numCharsToAdd: LinkedList<Char> = LinkedList()
        ) {
            if (visited.all { it }) return
            for (idx in visited.indices) {
                if (!visited[idx]) {
                    visited[idx] = true
                    numCharsToAdd.add(numbers[idx])
                    result.add(numCharsToAdd.joinToString("").toInt())
                    bruteForce(numbers, depth + 1, visited, numCharsToAdd)
                    visited[idx] = false
                    numCharsToAdd.removeLast()
                }
            }
        }
        bruteForce(numbers, 0)
        return result
    }

    private fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        (2..sqrt(number.toDouble()).toInt()).forEach {
            if (number % it == 0) return false
        }
        return true
    }
}

fun main() {
    Pr42839().apply {
        println(solution("17"))
        println(solution("011"))
        println(solution("123"))
    }
}