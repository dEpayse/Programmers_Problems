package lv1

class Pr68935 {
    fun solution(n: Int): Int = n.toString(3).reversed().toInt(3)
}

fun main() {
    Pr68935().apply {
        println(solution(45))
        println(solution(125))
    }
}