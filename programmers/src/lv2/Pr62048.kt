package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/62048
class Pr62048 {
    fun solution(w: Int, h: Int): Long {
        val gcd = gcd(w, h)
        val wFactor = w / gcd
        val hFactor = h / gcd
        return w * h.toLong() - gcd * (wFactor + hFactor - 1).toLong()
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
}

fun main() {
    Pr62048().apply {
        println(solution(8, 12))
    }
}