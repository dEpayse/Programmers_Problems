package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/161989
class Pr161989 {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var lastMaxPaintedIdx = -1
        var cnt = 0
        section.forEach {
            if(it - 1 <= lastMaxPaintedIdx) return@forEach
            cnt++
            lastMaxPaintedIdx = it + m - 2
        }
        return cnt
    }
}

fun main() {
    Pr161989().apply {
        println(solution(8, 4, intArrayOf(2, 3, 6)))
        println(solution(5, 4, intArrayOf(1, 3)))
        println(solution(4, 1, intArrayOf(1, 2, 3, 4)))
    }
}