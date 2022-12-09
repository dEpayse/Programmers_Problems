package lv1

class Pr12931 {
    fun solution(n: Int): Int {
        var answer = 0
        n.toString().forEach {
            answer += it.digitToInt()
        }
        return answer
    }
}

fun main() {
    Pr12931().apply {
        println(solution(123))
        println(solution(987))
    }
}