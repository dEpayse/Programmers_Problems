package lv1

class Pr12910 {
    fun solution(seoul: Array<String>): String = "김서방은 ${seoul.indexOf("Kim")}에 있다"
}

fun main() {
    Pr12910().apply {
        println(solution(arrayOf("Jane", "Kim")))
    }
}