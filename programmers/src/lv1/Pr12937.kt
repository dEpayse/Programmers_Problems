package lv1

class Pr12937 {
    fun solution(num: Int): String = if(num % 2 == 0) "Even" else "Odd"

}

fun main() {
    Pr12937().apply {
        println(solution(3))
        println(solution(4))
    }
}