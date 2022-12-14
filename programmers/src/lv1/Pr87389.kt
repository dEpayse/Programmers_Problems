package lv1

class Pr87389 {
    fun solution(n: Int): Int {
        (1..n).forEach {
            if(n % it == 1) return it
        }
        return -1
    }
}

fun main() {
    Pr87389().apply {
        println(solution(10))
        println(solution(12))
    }
}