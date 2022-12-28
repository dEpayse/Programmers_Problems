package lv1

import printIntArray

class Pr42748 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray =
        commands.map {
            array.asList().subList(it[0] - 1, it[1]).sorted()[it[2] - 1]
        }.toIntArray()
}

fun main() {
    Pr42748().apply {
        printIntArray(
            solution(
                intArrayOf(1, 5, 2, 6, 3, 7, 4),
                arrayOf(
                    intArrayOf(2, 5, 3),
                    intArrayOf(4, 4, 1),
                    intArrayOf(1, 7, 3)
                )
            )
        )
    }
}