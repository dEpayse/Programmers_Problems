package lv2

class Pr12945 {
    fun solution(n: Int): Int {
        var first = 0
        var second = 1
        if(n==0) return first
        else if(n==1) return second
        var idx = 2
        while(idx <= n) {
            val temp = second
            second = (second % 1234567 + first % 1234567) % 1234567
            first = temp
            idx++
        }
        return second
    }
}

fun main() {
    Pr12945().apply {
        println(solution(3))
        println(solution(5))
        println(solution(100))
    }
}