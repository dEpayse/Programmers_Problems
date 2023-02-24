package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/77885
class Pr77785 {
    fun solution(numbers: LongArray): LongArray =
        numbers.map { long ->
            if(long % 2L == 0L) long + 1
            else {
                val binaryStr = "0${long.toString(2)}"
                val lastZeroIdx = binaryStr.indexOfLast { it == '0' }
                StringBuilder(binaryStr).replace(lastZeroIdx, lastZeroIdx + 2, "10" ).toString().toLong(2)
            }
        }.toLongArray()
}

fun main() {
    Pr77785().apply {
        println(solution(longArrayOf(2, 7)).contentToString())
        println(solution(longArrayOf(3,5,7,9,11,13,15)).contentToString())
    }
}