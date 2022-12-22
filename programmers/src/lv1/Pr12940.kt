package lv1

import printIntArray

class Pr12940 {
    fun solution(n: Int, m: Int): IntArray = intArrayOf(gcd(n,m), n*m/gcd(n,m))

    fun gcd(n: Int, m: Int): Int {
        var bigger = n.coerceAtLeast(m)
        var smaller = n.coerceAtMost(m)
        while (smaller!=0) {
            val temp = bigger
            bigger = smaller
            smaller = temp % smaller
        }
        return bigger
    }
}

fun main() {
    Pr12940().apply {
        printIntArray(solution(3, 12))
        printIntArray(solution(2, 5))
    }
}