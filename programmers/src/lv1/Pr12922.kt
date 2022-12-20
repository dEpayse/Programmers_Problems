package lv1

class Pr12922 {
    fun solution(n: Int): String =
        (0 until n).fold("") { acc, elem ->
            if(elem % 2 == 0) acc + "수"
            else acc + "박"
        }
}

fun main() {
    Pr12922().apply {
        println(solution(3))
        println(solution(4))
    }
}