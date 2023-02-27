package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/68645
class Pr68645 {
    fun solution(n: Int): IntArray {
        val pyramid = List(n) { MutableList(it + 1) { 0 } }
        var rowIdx = 0
        var colIdx = 0
        var num = 1
        val totalSize = (1 + n) * n / 2
        while(num <= totalSize) {
            if(pyramid[rowIdx][colIdx] != 0 || rowIdx == pyramid.lastIndex) {
                if(pyramid[rowIdx][colIdx] != 0) {
                    rowIdx--
                    colIdx++
                }
                while(colIdx <= rowIdx) {
                    if(pyramid[rowIdx][colIdx] == 0) {
                        pyramid[rowIdx][colIdx] = num
                        num++
                        colIdx++
                        if(colIdx <= rowIdx) continue
                    }
                    colIdx--
                    colIdx--
                    rowIdx--
                    break
                }
                while(rowIdx >= 0) {
                    if(pyramid[rowIdx][colIdx] == 0) {
                        pyramid[rowIdx][colIdx] = num
                        num++
                        rowIdx--
                        colIdx--
                        continue
                    }
                    rowIdx++
                    rowIdx++
                    colIdx++
                    break
                }
                if(num > totalSize) break
            }
            pyramid[rowIdx][colIdx] = num
            num++
            rowIdx++
        }
        return pyramid.flatten().toIntArray()
    }
}

fun main() {
    Pr68645().apply {
        println(solution(4).contentToString())
        println(solution(5).contentToString())
        println(solution(6).contentToString())
    }
}