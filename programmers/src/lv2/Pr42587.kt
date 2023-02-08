package lv2

import java.util.LinkedList

// https://school.programmers.co.kr/learn/courses/30/lessons/42587
class Pr42587 {
    data class Content(val originalIdx: Int, val priority: Int)
    fun solution(priorities: IntArray, location: Int): Int {
        val contents = LinkedList<Content>()
        for (index in priorities.indices) {
            contents.add(Content(index, priorities[index]))
        }

        var idx = 0
        loop@ while (idx < contents.lastIndex) {
            for (compareIdx in idx + 1..contents.lastIndex) {
                if (contents[idx].priority < contents[compareIdx].priority) {
                    contents.addLast(contents.removeAt(idx))
                    continue@loop
                }
            }
            if(contents[idx].originalIdx == location) return idx + 1
            idx++
        }

        return contents.indexOfLast {
            it.originalIdx == location
        } + 1
    }

    fun solution2(priorities: IntArray, location: Int): Int {
        var answer = 0
        val sortedPriorities = LinkedList(priorities.sortedDescending())
        var idx = 0
        while(sortedPriorities.isNotEmpty()) {
            val head = sortedPriorities.first
            if(head == priorities[idx]) {
                if(idx == location) return answer + 1
                answer++
                sortedPriorities.poll()
                idx = increaseIdx(idx, priorities.lastIndex)
                continue
            }
            idx = increaseIdx(idx, priorities.lastIndex)
        }
        return answer + 1
    }

    private fun increaseIdx(idx: Int, lastIndex: Int): Int {
        val increasedIdx = idx + 1
        return if(increasedIdx > lastIndex) 0
        else increasedIdx
    }
}

fun main() {
    Pr42587().apply {
        println(
            solution(
                intArrayOf(2, 1, 3, 2),
                2
            )
        )
        println(
            solution(
                intArrayOf(1, 1, 9, 1, 1, 1),
                0
            )
        )
        println(
            solution(
                intArrayOf(1, 1, 9, 1, 1, 1, 9),
                0
            )
        )
    }
}