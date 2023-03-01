package lv2

class Pr132265 {
    fun solution(topping: IntArray): Int {
        val olderBrotherSet = hashSetOf<Int>()
        val youngerBrotherMap = hashMapOf<Int, Int>().apply {
            topping.groupBy { it }.forEach {
                set(it.key, it.value.size)
            }
        }
        var answer = 0
        topping.forEach {
            olderBrotherSet.add(it)
            youngerBrotherMap[it] = youngerBrotherMap.getValue(it) - 1
            if(youngerBrotherMap.getValue(it) == 0) youngerBrotherMap.remove(it)
            if(olderBrotherSet.size == youngerBrotherMap.size) answer++
        }
        return answer
    }
}

fun main() {
    Pr132265().apply {
        println(solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)))
        println(solution(intArrayOf(1, 2, 3, 1, 4)))
    }
}