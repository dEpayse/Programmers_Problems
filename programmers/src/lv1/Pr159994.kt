package lv1

import java.util.LinkedList

class Pr159994 {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        val queue1 = LinkedList(cards1.toList())
        val queue2 = LinkedList(cards2.toList())
        for(str in goal) {
            val candidate1 = if(queue1.isNotEmpty()) queue1.peek() else ""
            val candidate2 = if(queue2.isNotEmpty()) queue2.peek() else ""
            if(str == candidate1) {
                queue1.poll()
                continue
            }
            if(str == candidate2) {
                queue2.poll()
                continue
            }
            return "No"
        }
        return "Yes"
    }
}

fun main() {
    Pr159994().apply {
        println(
            solution(
                arrayOf("i", "drink", "water"),
                arrayOf("want", "to"),
                arrayOf("i", "want", "to", "drink", "water")
            )
        )
        println(
            solution(
                arrayOf("i", "water", "drink"),
                arrayOf("want", "to"),
                arrayOf("i", "want", "to", "drink", "water")
            )
        )
    }
}