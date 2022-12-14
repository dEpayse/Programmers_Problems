package lv1

class Pr12933 {
    fun solution(n: Long): Long = n.toString().toList().sortedDescending().joinToString("").toLong()
}

fun main() {
    Pr12933().apply {
        println(solution(118372))
    }
}