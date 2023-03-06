package lv1

// https://school.programmers.co.kr/learn/courses/30/lessons/155652
class Pr155652 {
    fun solution(s: String, skip: String, index: Int): String =
        s.map {
            var cnt = 0
            var char = it
            while(cnt < index) {
                char += 1
                if(char > 'z') char = 'a'
                if(skip.contains(char)) continue
                cnt++
            }
            char
        }.joinToString("")
}

fun main() {
    Pr155652().apply {
        println(
            solution(
                "aukks",
                "wbqd",
                5
            )
        )
    }
}