package lv2

class Pr12914 {
    fun solution(n: Int): Long = transformedFibonacci(n).toLong()

    private fun transformedFibonacci(n: Int): Int {
        var smaller = 0
        var bigger = 1
        var i = 0
        while(i != n) {
            val temp = bigger
            bigger = (smaller + bigger) % 1234567
            smaller = temp
            i++
        }
        return bigger
    }
}

fun main() {
    Pr12914().apply {
        println(solution(4))
        println(solution(3))
    }
}