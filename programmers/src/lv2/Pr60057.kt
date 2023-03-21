package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
class Pr60057 {
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE
        if(s.length == 1) return 1
        (1..s.length/2).forEach { unit ->
            val strBuilder = StringBuilder()
            val splitStrList = s.chunked(unit)
            var tempStr = splitStrList.first()
            var repeatCnt = 0
            splitStrList.forEachIndexed { idx , it ->
                if(it == tempStr) {
                    repeatCnt++
                    return@forEachIndexed
                }
                if(repeatCnt != 1) strBuilder.append(repeatCnt)
                strBuilder.append(tempStr)
                tempStr = it
                repeatCnt = 1
            }
            if(repeatCnt != 1) strBuilder.append(repeatCnt)
            strBuilder.append(tempStr)
            if(strBuilder.length < answer) answer = strBuilder.length
        }
        return answer
    }
}

fun main() {
    Pr60057().apply {
        println(solution("aabbaccc"))
        println(solution("ababcdcdababcdcd"))
        println(solution("abcabcdede"))
        println(solution("abcabcabcabcdededededede"))
        println(solution("xababcdcdababcdcd"))
        println(solution("a"))
    }
}