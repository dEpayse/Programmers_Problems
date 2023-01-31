package lv2

class Pr12953 {
    fun solution(arr: IntArray): Int =
        arr.fold(arr.first()) { acc, it ->
            lcm(acc, it)
        }


    private fun gcd(a: Int, b: Int): Int {
        var bigger = a.coerceAtLeast(b)
        var smaller = a.coerceAtMost(b)

        while (smaller != 0) {
            val temp = bigger
            bigger = smaller
            smaller = temp % smaller
        }

        return bigger
    }

    private fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)
}

fun main() {
    Pr12953().apply {
        println(solution(intArrayOf(2, 6, 8, 14)))
        println(solution(intArrayOf(1, 2, 3)))
        println(solution(intArrayOf(7, 23, 91)))
        println(solution(intArrayOf(3, 4, 9, 16)))
    }
}