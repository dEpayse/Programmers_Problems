package lv2

import java.util.LinkedList
import kotlin.math.abs

//https://school.programmers.co.kr/learn/courses/30/lessons/86971
class Pr86971 {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        wires.forEachIndexed { idx, it ->
            val remainWires = wires.sliceArray(0 until idx) + wires.sliceArray(idx + 1..wires.lastIndex)
            val result = abs(getConnectedNodeCnt(it[0], remainWires) - getConnectedNodeCnt(it[1], remainWires))
            if(result < answer) answer = result
        }
        return answer
    }

    private fun getConnectedNodeCnt(nodeNum: Int, remainWires: Array<IntArray>): Int {
        val connectedNodeSet = mutableSetOf(nodeNum)
        val nodesToVisit = LinkedList<Int>().apply { offer(nodeNum) }
        while(nodesToVisit.isNotEmpty()) {
            val visitingNode = nodesToVisit.poll()
            remainWires
                .filter { !it.all { it1-> connectedNodeSet.contains(it1) } && it.contains(visitingNode)  }
                .forEach {
                    val nextNode = if(it[0] == visitingNode) it[1] else it[0]
                    connectedNodeSet.add(nextNode)
                    nodesToVisit.offer(nextNode)
                }
        }
        return connectedNodeSet.size
    }
}

fun main() {
    Pr86971().apply {
        println(
            solution(
                9,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(4, 6),
                    intArrayOf(4, 7),
                    intArrayOf(7, 8),
                    intArrayOf(7, 9)
                )
            )
        )
        println(
            solution(
                4,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4)
                )
            )
        )
        println(
            solution(
                7,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 7),
                    intArrayOf(3, 7),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(6, 7)
                )
            )
        )
    }
}