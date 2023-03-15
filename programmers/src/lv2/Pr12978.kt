package lv2

import java.util.PriorityQueue

class Pr12978 {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int
        = dijkstraPQ(N, 1, road).count { it <= k }

    // 선형 탐색으로 최솟값을 찾는 데익스트라 알고리즘
    private fun dijkstraLinear(N: Int, start: Int, road: Array<IntArray>): IntArray {
        val isVisitedArr = BooleanArray(N + 1) { it == start }
        val minDistanceArr = IntArray(N + 1) { if (it == start) 0 else Int.MAX_VALUE }

        fun getMinCostNode(): Int {
            var min = Int.MAX_VALUE
            var minNode = -1
            (0 until N).forEach {
                if (!isVisitedArr[it] && minDistanceArr[it] < min) {
                    min = minDistanceArr[it]
                    minNode = it
                }
            }
            return minNode
        }

        road.filter { it.first() == 1 }.forEach {
            val adjacentNode = it[1]
            minDistanceArr[adjacentNode] = it[2]
        }
        repeat(N - 2) {
            val visitingIdx = getMinCostNode()
            isVisitedArr[visitingIdx] = true
            road.filter {
                    it[0] == visitingIdx || it[1] == visitingIdx
                }.forEach {
                    val adjacentNode = if(it[0] != visitingIdx) it[0] else it[1]
                    val newCost = minDistanceArr[visitingIdx] + it[2]
                    if (newCost < minDistanceArr[adjacentNode]) minDistanceArr[adjacentNode] = newCost
                }
        }
        return minDistanceArr.sliceArray(1..minDistanceArr.lastIndex)
    }

    // Priority Queue 를 사용해 최솟값을 찾는 데익스트라 알고리즘
    private fun dijkstraPQ(N: Int, start: Int, road: Array<IntArray>): IntArray {
        val minDistanceArr = IntArray(N + 1) { if (it == start) 0 else Int.MAX_VALUE }
        val availableMinDistancePQ = PriorityQueue<Pair<Int, Int>> { (_, d1), (_, d2) -> d1.compareTo(d2) }.apply {
            offer(Pair(start, 0))
        }
        while(availableMinDistancePQ.isNotEmpty()) {
            val (visitingNode, distanceToVisitingNode) = availableMinDistancePQ.poll()
            if(minDistanceArr[visitingNode] < distanceToVisitingNode) continue
            road.filter { it[0] == visitingNode || it[1] == visitingNode }
                .forEach {
                    val adjacentNode = if(it[0] != visitingNode) it[0] else it[1]
                    val startToAdjacentDistance = distanceToVisitingNode + it[2]
                    if(startToAdjacentDistance < minDistanceArr[adjacentNode]) {
                        minDistanceArr[adjacentNode] = startToAdjacentDistance
                        availableMinDistancePQ.offer(Pair(adjacentNode, startToAdjacentDistance))
                    }
                }
        }
        return minDistanceArr.sliceArray(1..minDistanceArr.lastIndex)
    }
}

fun main() {
    Pr12978().apply {
        println(
            solution(
                5,
                arrayOf(
                    intArrayOf(1, 2, 1),
                    intArrayOf(2, 3, 3),
                    intArrayOf(5, 2, 2),
                    intArrayOf(1, 4, 2),
                    intArrayOf(5, 3, 1),
                    intArrayOf(5, 4, 2)
                ),
                3
            )
        )
        println(
            solution(
                6,
                arrayOf(
                    intArrayOf(1, 2, 1),
                    intArrayOf(1, 3, 2),
                    intArrayOf(2, 3, 2),
                    intArrayOf(3, 4, 3),
                    intArrayOf(3, 5, 2),
                    intArrayOf(3, 5, 3),
                    intArrayOf(5, 6, 1)
                ),
                4
            )
        )
    }
}