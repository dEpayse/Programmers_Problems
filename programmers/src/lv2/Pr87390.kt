package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/87390
class Pr87390 {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val leftRow = (left / n).toInt()
        val leftCol = (left % n).toInt()
        val rightRow = (right / n).toInt()
        val rightCol = (right % n).toInt()
        val tempArr = Array(rightRow - leftRow + 1) { IntArray(n) { 0 } }
        (leftRow..rightRow).forEachIndexed { rowIdx, row ->
            (0 until n).forEach { colIdx ->
                val bigger = row.coerceAtLeast(colIdx)
                tempArr[rowIdx][colIdx] = bigger + 1
            }
        }
        return tempArr
            .flatMap { it.toList() }
            .subList(leftCol, n * (rightRow - leftRow) + rightCol + 1)
            .toIntArray()
    }
}

fun main() {
    Pr87390().apply {
        println(solution(3, 2, 5).contentToString())
        println(solution(4, 7, 14).contentToString())
    }
}