package lv2

import java.util.*

// https://school.programmers.co.kr/learn/challenges?order=acceptance_desc&levels=2&languages=kotlin&page=2
class Pr60058 {
    fun solution(p: String): String {
        if (p.isEmpty()) return ""
        val bracketMap = hashMapOf('(' to 0, ')' to 0)
        val uBuilder = StringBuilder()
        val vBuilder = StringBuilder()
        for (idx in p.indices) {
            bracketMap[p[idx]] = bracketMap.getValue(p[idx]) + 1
            uBuilder.append(p[idx])
            if(bracketMap.getValue('(') == bracketMap.getValue(')')) {
                if(idx < p.lastIndex) vBuilder.append(p.substring(idx + 1))
                break
            }
        }
        if(!isCorrectBracketString(uBuilder.toString())) {
            val uReversed = uBuilder.toString().substring(1, uBuilder.lastIndex).map {
                if(it == '(') ')'
                else '('
            }.joinToString("")
            return "(${solution(vBuilder.toString())})${uReversed}"
        }
        return uBuilder.toString() + solution(vBuilder.toString())
    }

    private fun isCorrectBracketString(str: String): Boolean {
        val stack = Stack<Char>()
        str.forEach {
            if(stack.isEmpty()) {
                stack.push(it)
                return@forEach
            }
            if(it == ')') {
                if(stack.peek() == '('){
                    stack.pop()
                    return@forEach
                }
                return false
            }
            else stack.push(it)
        }
        return stack.isEmpty()
    }
}

fun main() {
    Pr60058().apply {
        println(solution("(()())()"))
        println(solution(")("))
        println(solution("()))((()"))
    }
}