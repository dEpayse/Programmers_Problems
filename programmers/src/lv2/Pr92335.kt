package lv2

import kotlin.math.sqrt

class Pr92335 {
    fun solution(n: Int, k: Int): Int =
        n.toString(k)
            .split("0")
            .filterNot { it.isEmpty() }
            .count { isPrime(it.toLong()) }


    private fun isPrime(n: Long): Boolean {
        if (n <= 1) return false
        (2..sqrt(n.toDouble()).toLong()).forEach {
            if (n % it == 0L) return false
        }
        return true
    }
}

fun main() {
    Pr92335().apply {
        println(solution(437674, 3))
        println(solution(110011, 10))
        println(solution(1000000, 3))
    }
}