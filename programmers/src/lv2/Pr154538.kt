package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/154538
class Pr154538 {
    fun solution(x: Int, y: Int, n: Int): Int {
        val minCntArr = IntArray(y + 1) {
            if(it == x) 0
            else -1
        }
        (x + 1..y).forEach {
            if(it - n < x) return@forEach
            val min = listOf(
                minCntArr[it - n],
                if(it % 2 == 0) minCntArr[it / 2] else -1,
                if(it % 3 == 0) minCntArr[it / 3] else -1
            ).filterNot { it1 -> it1 == -1 }.minOrNull()
            minCntArr[it] =
                if(min != -1 && min != null) min + 1
                else -1
        }
        return minCntArr[y]
    }
}

fun main() {
    Pr154538().apply {
        println(solution(10, 40, 5))
        println(solution(10, 40, 30))
        println(solution(2, 5, 4))
        println(solution(0,40,5))
    }
}