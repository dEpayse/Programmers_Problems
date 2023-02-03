package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/12949
class Pr12949 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr2[0].size) }
        arr1.indices.forEach { rowIdx ->
            arr2[0].indices.forEach { colIdx ->
                var value = 0
                arr1[rowIdx].forEachIndexed { idx, it ->
                    value += it * arr2[idx][colIdx]
                }
                answer[rowIdx][colIdx] = value
            }
        }
        return answer
    }
}

fun main() {
    Pr12949().apply {
        println(
            solution(
                arrayOf(
                    intArrayOf(1,4),
                    intArrayOf(3,2),
                    intArrayOf(4,1)
                ),
                arrayOf(
                    intArrayOf(3,3),
                    intArrayOf(3,3)
                )
            ).contentDeepToString()
        )
        println(
            solution(
                arrayOf(
                    intArrayOf(2,3,2),
                    intArrayOf(4,2,4),
                    intArrayOf(3,1,4)
                ),
                arrayOf(
                    intArrayOf(5,4,3),
                    intArrayOf(2,4,1),
                    intArrayOf(3,1,1)
                )
            ).contentDeepToString()
        )
    }
}