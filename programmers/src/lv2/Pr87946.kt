package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
class Pr87946 {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = Int.MIN_VALUE
        bruteForce(dungeons).forEach {
            val temp = enableDungeonCnt(k, it)
            if(temp > answer) answer = temp
        }
        return answer
    }

    private fun enableDungeonCnt(fatigue: Int, dungeons: Array<IntArray>): Int {
        var curFatigue = fatigue
        var dungeonCnt = 0
        dungeons.forEach {
            if(curFatigue < it[0]) return dungeonCnt
            curFatigue -= it[1]
            dungeonCnt++
        }
        return dungeonCnt
    }

    private fun <T> bruteForce(arr: Array<T>): List<Array<T>> {
        val allCases = mutableListOf<Array<T>>()
        fun bruteForceRecursive(arr: Array<T>, depth: Int) {
            if(depth == arr.lastIndex) {
                allCases.add(arr)
                return
            }
            (depth..arr.lastIndex).forEach { toSwapIdx ->
                val tempArr = arr.clone().apply {
                    val temp = get(depth)
                    set(depth, get(toSwapIdx))
                    set(toSwapIdx, temp)
                }
                bruteForceRecursive(tempArr, depth + 1)
            }
        }
        bruteForceRecursive(arr, 0)
        return allCases
    }
}

fun main() {
    Pr87946().apply {
        println(
            solution(
                80,
                arrayOf(
                    intArrayOf(80, 20),
                    intArrayOf(50, 40),
                    intArrayOf(30, 10)
                )
            )
        )
    }
}