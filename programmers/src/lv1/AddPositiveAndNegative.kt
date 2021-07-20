package lv1

fun main() {
    println(solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true)))
    println(solution(intArrayOf(1, 2, 3), booleanArrayOf(false, false, true)))
}

fun solution(absolutes: IntArray, signs: BooleanArray): Int =
    absolutes.foldIndexed(0) { index, acc, elem ->
        when (signs[index]) {
            true -> acc + elem
            false -> acc - elem
        }
    }

