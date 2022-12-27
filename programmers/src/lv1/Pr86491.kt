package lv1

class Pr86491 {
    fun solution(sizes: Array<IntArray>): Int =
        sizes
            .map {
                it.sorted()
            }.let {
                it.maxOf { it1 -> it1[0] } * it.maxOf { it1 -> it1[1] }
            }
}

fun main() {
    Pr86491().apply {
        println(
            solution(
                arrayOf(
                    intArrayOf(60, 50),
                    intArrayOf(30, 70),
                    intArrayOf(60, 30),
                    intArrayOf(80, 40)
                )
            )
        )
        println(
            solution(
                arrayOf(
                    intArrayOf(10, 7),
                    intArrayOf(12, 3),
                    intArrayOf(8, 15),
                    intArrayOf(14, 7),
                    intArrayOf(5, 15)
                )
            )
        )
        println(
            solution(
                arrayOf(
                    intArrayOf(14, 4),
                    intArrayOf(19, 6),
                    intArrayOf(6, 16),
                    intArrayOf(18, 7),
                    intArrayOf(7, 11)
                )
            )
        )
    }
}