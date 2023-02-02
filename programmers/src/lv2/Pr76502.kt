package lv2

import java.util.*

class Pr76502 {
    fun solution(s: String): Int {
        var answer = 0
        var tempS = s
        repeat(s.length) {
            if(isRight(tempS)) answer++
            tempS = "${tempS.last()}${tempS.substring(0, tempS.lastIndex)}"
        }
        return answer
    }

    private fun isRight(s: String): Boolean {
        val stack = Stack<Char>()
        val rightBracketMap = mapOf(')' to '(', ']' to '[', '}' to '{')
        s.forEach {
            if(stack.isNotEmpty() && rightBracketMap.getOrDefault(it, ' ') == stack.peek()) stack.pop()
            else stack.push(it)
        }
        return stack.empty()
    }
}

fun main() {
    Pr76502().apply {
        println(solution("[](){}"))
        println(solution("}]()[{"))
        println(solution("[)(]"))
        println(solution("}}}"))
    }
}