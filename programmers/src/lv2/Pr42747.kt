package lv2

class Pr42747 {
    fun solution(citations: IntArray): Int {
        citations.sorted().forEach {
            if (it > citations.count { elem -> elem >= it }) {
                (it downTo 0).forEach { it1 ->
                    if(it1 <= citations.count { elem -> elem >= it1 }) return it1
                }
            }
        }
        return 0
    }
}

fun main() {
    Pr42747().apply {
        println(solution(intArrayOf(3,0,6,1,5)))
    }
}