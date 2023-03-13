package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/77485
class Pr77485 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size)
        val matrix = Array(rows) { rowIdx ->
            IntArray(columns) { colIdx ->
                rowIdx * columns + colIdx + 1
            }
        }
        queries.forEachIndexed { idx, query ->
            answer[idx] = rotateClockwiseAndGetMin(matrix, query)
        }
        return answer
    }

    private fun rotateClockwiseAndGetMin(matrix: Array<IntArray>, query: IntArray): Int {
        val fromRowIdx = query[0] - 1
        val fromColIdx = query[1] - 1
        val toRowIdx = query[2] - 1
        val toColIdx = query[3] - 1
        var previous = matrix[fromRowIdx][fromColIdx]
        var min = previous
        // topSide
        (fromColIdx + 1..toColIdx).forEach { colIdx ->
            val temp = matrix[fromRowIdx][colIdx]
            matrix[fromRowIdx][colIdx] = previous
            previous = temp
            if(previous < min) min = previous
        }
        // rightSide
        (fromRowIdx + 1 .. toRowIdx).forEach { rowIdx ->
            val temp = matrix[rowIdx][toColIdx]
            matrix[rowIdx][toColIdx] = previous
            previous = temp
            if(previous < min) min = previous
        }
        // bottomSide
        (toColIdx - 1 downTo fromColIdx).forEach { colIdx ->
            val temp = matrix[toRowIdx][colIdx]
            matrix[toRowIdx][colIdx] = previous
            previous = temp
            if(previous < min) min = previous
        }
        // leftSide
        (toRowIdx - 1 downTo fromRowIdx).forEach { rowIdx ->
            val temp = matrix[rowIdx][fromColIdx]
            matrix[rowIdx][fromColIdx] = previous
            previous = temp
            if(previous < min) min = previous
        }
        return min
    }
}

fun main() {
    Pr77485().apply {
        println(
            solution(
                6,
                6,
                arrayOf(
                    intArrayOf(2, 2, 5, 4),
                    intArrayOf(3, 3, 6, 5),
                    intArrayOf(5, 1, 6, 3)
                )
            ).contentToString()
        )
        println(
            solution(
                3,
                3,
                arrayOf(
                    intArrayOf(1, 1, 2, 2),
                    intArrayOf(1, 2, 2, 3),
                    intArrayOf(2, 1, 3, 2),
                    intArrayOf(2, 2, 3, 3)
                )
            ).contentToString()
        )
        println(
            solution(
                100,
                97,
                arrayOf(
                    intArrayOf(1, 1, 100, 97)
                )
            ).contentToString()
        )
    }
}