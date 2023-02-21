package lv2

class Pr92341 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val (minTimeMinutes, minFee, unitTimeMinutes, unitFee) = fees
        return records.groupBy { it.split(" ")[1] }
            .toSortedMap()
            .map { (_, list) ->
                val parkingTimeMinutes = list.map { record ->
                    val (time, _, _) = record.split(" ")
                    val (hour, minutes) = time.split(":")
                    val timeToMinutes = hour.toInt() * 60 + minutes.toInt()
                    timeToMinutes
            }.chunked(2)
            .sumOf {
                if (it.size < 2) 23 * 60 + 59 - it[0]
                else it[1] - it[0]
            }
                if(parkingTimeMinutes <= minTimeMinutes) minFee
                else {
                    minFee + (Math.ceil((parkingTimeMinutes-minTimeMinutes).toDouble()/unitTimeMinutes) * unitFee).toInt()
                }
            }.toIntArray()
    }
}

fun main() {
    Pr92341().apply {
        println(
            solution(
                intArrayOf(180, 5000, 10, 600),
                arrayOf(
                    "05:34 5961 IN",
                    "06:00 0000 IN",
                    "06:34 0000 OUT",
                    "07:59 5961 OUT",
                    "07:59 0148 IN",
                    "18:59 0000 IN",
                    "19:09 0148 OUT",
                    "22:59 5961 IN",
                    "23:00 5961 OUT"
                )
            ).contentToString()
        )

        println(
            solution(
                intArrayOf(120, 0, 60, 591),
                arrayOf("16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN")
            ).contentToString()
        )

        println(
            solution(
                intArrayOf(1, 461, 1, 10),
                arrayOf("00:00 1234 IN")
            ).contentToString()
        )
    }
}