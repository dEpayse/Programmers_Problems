package lv1

class Pr131705 {
    fun solution(number: IntArray): Int {
        var answer = 0
        (0 until number.size - 2).forEach { first ->
            (first + 1 until number.size - 1).forEach { second ->
                (second + 1 until number.size).forEach { third ->
                    if (number[first] + number[second] + number[third] == 0) answer++
                }
            }
        }
        return answer
    }
}

fun main() {
    Pr131705().apply {
        println(solution(intArrayOf(-2, 3, 0, 2, -5)))
        println(solution(intArrayOf(-3, -2, -1, 0, 1, 2, 3)))
        println(solution(intArrayOf(-1, 1, -1, 1)))
    }
}