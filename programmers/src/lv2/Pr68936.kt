package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/68936
class Pr68936 {
    fun solution(arr: Array<IntArray>): IntArray {
        val answer = intArrayOf(0, 0)
        quadCompression(arr, answer)
        return answer
    }

    private fun quadCompression(arr: Array<IntArray>, answer: IntArray) {
        if(arr.size == 1 || isAllSame(arr)) {
            answer[arr.first().first()]++
            return
        }
        (0 until 4).forEach {
            val frontRange = 0 until arr.size/2
            val backRange = arr.size/2 until arr.size

            val rowIndices = if(it < 2) frontRange else backRange
            val colIndices = if(it % 2 == 0) frontRange else backRange

            val subSquare = arr.sliceArray(rowIndices).map { it.sliceArray(colIndices) }.toTypedArray()
            if(isAllSame(subSquare)) {
                answer[subSquare.first().first()]++
                return@forEach
            }
            quadCompression(subSquare, answer)
        }
    }

    private fun isAllSame(arr: Array<IntArray>): Boolean {
        arr.forEach {
            it.forEach { elem ->
                if(elem != arr.first().first()) return false
            }
        }
        return true
    }
}

fun main() {
    Pr68936().apply {
        println(
            solution(
                arrayOf(
                    intArrayOf(1,1,0,0),
                    intArrayOf(1,0,0,0),
                    intArrayOf(1,0,0,1),
                    intArrayOf(1,1,1,1)
                )
            ).contentToString()
        )
        println(
            solution(
                arrayOf(
                    intArrayOf(1,1,1,1,1,1,1,1),
                    intArrayOf(0,1,1,1,1,1,1,1),
                    intArrayOf(0,0,0,0,1,1,1,1),
                    intArrayOf(0,1,0,0,1,1,1,1),
                    intArrayOf(0,0,0,0,0,0,1,1),
                    intArrayOf(0,0,0,0,0,0,0,1),
                    intArrayOf(0,0,0,0,1,0,0,1),
                    intArrayOf(0,0,0,0,1,1,1,1)
                )
            ).contentToString()
        )
        println(
            solution(
                arrayOf(
                    intArrayOf(1,1,1,1),
                    intArrayOf(1,1,1,1),
                    intArrayOf(1,1,1,1),
                    intArrayOf(1,1,1,1)
                )
            ).contentToString()
        )
    }
}