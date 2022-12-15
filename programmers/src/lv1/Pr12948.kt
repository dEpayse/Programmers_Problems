package lv1

class Pr12948 {
    fun solution(phone_number: String): String =
        phone_number.mapIndexed { index, c ->
            if(index >= phone_number.length - 4) c
            else '*'
        }.joinToString("")
}

fun main() {
    Pr12948().apply {
        println(solution("01033334444"))
        println(solution("027778888"))
    }
}