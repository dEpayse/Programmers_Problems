package lv2

import java.util.*

// https://school.programmers.co.kr/learn/courses/30/lessons/154539
class Pr154539 {
    fun solution(numbers: IntArray): IntArray {
        return IntArray(numbers.size).also { answer ->
            val stack = Stack<Int>()
            for(idx in numbers.lastIndex downTo 0) {
                var isFirst = true
                do {
                    if(!isFirst) stack.pop() else isFirst = false
                    if(stack.isEmpty()) {
                        answer[idx] = -1
                        stack.push(numbers[idx])
                        break
                    }
                    if(numbers[idx] < stack.peek()) {
                        answer[idx] = stack.peek()
                        stack.push(numbers[idx])
                        break
                    }
                } while(numbers[idx] >= stack.peek())
            }
        }
    }
}

fun main() {
    Pr154539().apply {
        println(solution(intArrayOf(2, 3, 3, 5)).contentToString())
        println(solution(intArrayOf(9, 1, 5, 3, 6, 2)).contentToString())
    }
}