package lv1

fun main() {
    printIntArray(solution(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19)))
    printIntArray(solution(intArrayOf(0, 0, 0, 0, 0, 0), intArrayOf(38, 19, 20, 40, 15, 25)))
    printIntArray(solution(intArrayOf(45, 4, 35, 20, 3, 9), intArrayOf(20, 9, 3, 45, 4, 35)))
}

fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    fun getGrade(correctNum: Int): Int =
        when (correctNum) {
            2 -> 5
            3 -> 4
            4 -> 3
            5 -> 2
            6 -> 1
            else -> 6
        }

    val maxList = lottos.filter { it == 0 || win_nums.contains(it) }
    val minList = maxList.filter { win_nums.contains(it) }

    return intArrayOf(getGrade(maxList.size), getGrade(minList.size))
}

fun printIntArray(intArray: IntArray) {
    print("[")
    for ((index, i) in intArray.withIndex()) {
        if (index == intArray.lastIndex) print("$i")
        else print("$i, ")
    }
    println("]")
}