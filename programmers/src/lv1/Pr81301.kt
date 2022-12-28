package lv1

class Pr81301 {
    fun solution(s: String): Int =
        s.replace("zero", "0")
            .replace("one", "1")
            .replace("two", "2")
            .replace("three", "3")
            .replace("four", "4")
            .replace("five", "5")
            .replace("six", "6")
            .replace("seven", "7")
            .replace("eight", "8")
            .replace("nine", "9")
            .toInt()
}

fun main() {
    Pr81301().apply {
        println(solution("one4seveneight"))
        println(solution("23four5six7"))
        println(solution("2three45sixseven"))
        println(solution("123"))
    }
}