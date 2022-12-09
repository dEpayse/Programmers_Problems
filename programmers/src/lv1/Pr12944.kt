package lv1

class Pr12944 {
    fun solution(arr: IntArray): Double = arr.average()
}

fun main() {
    Pr12944().apply {
        println(solution(intArrayOf(1,2,3,4)))
        println(solution(intArrayOf(5,5)))
    }
}