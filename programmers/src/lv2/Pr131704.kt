package lv2

import java.util.*

class Pr131704 {
    fun solution(order: IntArray): Int {
        var answer = 0
        val subBelt = Stack<Int>()
        var mainBeltBoxNum = 1
        for(it in order) {
            when {
                mainBeltBoxNum > it -> {
                    if(subBelt.peek() == it) {
                        subBelt.pop()
                        answer++
                        continue
                    }
                    break
                }
                mainBeltBoxNum < it -> {
                    while(mainBeltBoxNum < it) {
                        subBelt.push(mainBeltBoxNum)
                        mainBeltBoxNum++
                    }
                    mainBeltBoxNum++
                    answer++
                }
                else -> {
                    mainBeltBoxNum++
                    answer++
                }
            }
        }
        return answer
    }
}

fun main() {
    Pr131704().apply {
        println(solution(intArrayOf(4, 3, 1, 2, 5)))
        println(solution(intArrayOf(5, 4, 3, 2, 1)))
    }
}