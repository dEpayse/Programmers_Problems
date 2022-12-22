package lv1

class Pr12950 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> =
        arr1.mapIndexed { idx, ints ->
            ints.zip(arr2[idx]).map { (arr1Int, arr2Int) ->
                arr1Int + arr2Int
            }.toIntArray()
        }.toTypedArray()
}

fun main() {
    Pr12950().apply {
        println(solution(arrayOf(intArrayOf(1,2), intArrayOf(2,3)), arrayOf(intArrayOf(3,4), intArrayOf(5,6))))
        println(solution(arrayOf(intArrayOf(1), intArrayOf(2)), arrayOf(intArrayOf(3), intArrayOf(4))))
    }
}