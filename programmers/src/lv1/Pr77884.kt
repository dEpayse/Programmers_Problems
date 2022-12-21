package lv1

import kotlin.math.sqrt

class Pr77884 {
    fun solution(left: Int, right: Int): Int =
        (left..right).sumOf {
            if(sqrt(it.toFloat()) % 1f == 0f) -it
            else it
        }
}

fun main() {
    Pr77884().apply {
        println(solution(13, 17))
        println(solution(24, 27))
    }
}