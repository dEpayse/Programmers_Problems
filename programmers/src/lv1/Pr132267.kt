package lv1

class Pr132267 {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer = 0
        var remainder = n
        while(remainder >= a) {
            val newCoke = remainder / a * b
            answer += newCoke
            remainder = newCoke + remainder % a
        }
        return answer
    }
}

fun main() {
    Pr132267().apply {
        println(solution(3, 2, 20))
    }
}