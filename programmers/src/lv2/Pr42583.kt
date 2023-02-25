package lv2

import java.util.LinkedList

class Pr42583 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var sec = 0
        val bridgePassingQueue = LinkedList<BridgeTruck>()
        val leftTruckWeights = LinkedList(truck_weights.toList())
        while (leftTruckWeights.isNotEmpty() || bridgePassingQueue.isNotEmpty()) {
            val nextTruckWeight = leftTruckWeights.peekFirst()
            if (bridgePassingQueue.isNotEmpty() &&
                bridgePassingQueue.peek().truckBridgeSec > bridge_length
            ) {
                bridgePassingQueue.poll()
            }
            if (leftTruckWeights.isNotEmpty()
                && bridgePassingQueue.size < bridge_length
                && nextTruckWeight + bridgePassingQueue.sumOf { (truckWeight, _) -> truckWeight } <= weight
            ) {
                bridgePassingQueue.offer(BridgeTruck(leftTruckWeights.pollFirst()))
            }

            bridgePassingQueue.forEach { it.truckBridgeSec++ }
            sec++
        }
        return sec
    }

    data class BridgeTruck(val truckWeight: Int, var truckBridgeSec: Int = 1)
}

fun main() {
    Pr42583().apply {
        println(solution(2, 10, intArrayOf(7, 4, 5, 6)))
        println(solution(100, 100, intArrayOf(10)))
        println(solution(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
    }

}