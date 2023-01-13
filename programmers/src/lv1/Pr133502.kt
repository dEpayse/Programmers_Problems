package lv1

import java.util.Stack

class Pr133502 {
    fun solution(ingredient: IntArray): Int {
        var answer = 0
        var incomingIngredients = ""
        val burger = "1231"
        ingredient.forEach {
            incomingIngredients = "${incomingIngredients}$it"
            if (incomingIngredients.contains("1231")) {
                answer++
                incomingIngredients = incomingIngredients.replace(burger, "")
                var haveToClear = true
                for(i in (1..burger.lastIndex)) {
                    if(incomingIngredients.takeLast(i) == burger.take(i)) {
                        haveToClear = false
                        break
                    }
                }
                if(haveToClear) incomingIngredients = ""
            }
        }
        return answer
    }

    fun solution2(ingredient: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()
        ingredient.forEach {
            stack.push(it)
            if(stack.takeLast(4) == listOf(1,2,3,1)) {
                answer++
                repeat(4) { stack.pop() }
            }
        }
        return answer
    }
}

fun main() {
    Pr133502().apply {
        println(solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))
        println(solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)))
    }
}