package lv2

import java.util.LinkedList

class Pr118667 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val realQueue1 = LinkedList(queue1.toList())
        val realQueue2 = LinkedList(queue2.toList())
        var sum1 = queue1.sumOf { it.toLong() }
        var sum2 = queue2.sumOf { it.toLong() }
        val total = sum1 + sum2
        if((sum1 + sum2) % 2 != 0L) return -1
        realQueue1.forEach {
            if(it > total / 2) return -1
        }
        realQueue2.forEach {
            if(it > total / 2) return -1
        }
        var cnt = 0
        while (sum1 != sum2) {
            if(sum1 < total / 2) {
                sum1 += realQueue2.peek()
                sum2 -= realQueue2.peek()
                realQueue1.offer(realQueue2.poll())
            }
            else {
                sum1 -= realQueue1.peek()
                sum2 += realQueue1.peek()
                realQueue2.offer(realQueue1.poll())
            }
            cnt++
            if(cnt > queue1.size * 4) return -1
        }
        return cnt
    }
}

fun main() {
    Pr118667().apply {
        println(
            solution(
                intArrayOf(3, 2, 7, 2),
                intArrayOf(4, 6, 5, 1)
            )
        )
        println(
            solution(
                intArrayOf(1, 2, 1, 2),
                intArrayOf(1, 10, 1, 2)
            )
        )
        println(
            solution(
                intArrayOf(1, 1),
                intArrayOf(1, 5)
            )
        )
    }
}