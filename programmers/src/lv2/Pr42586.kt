package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
class Pr42586 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val daysList = progresses
            .mapIndexed { idx, it ->
                val left = 100 - it
                if (left % speeds[idx] > 0) (left / speeds[idx]) + 1
                else left / speeds[idx]
            }
        var tempMax = daysList[0]
        var tempCnt = 0
        daysList.forEach {
            if(tempMax < it) {
                tempMax = it
                answer.add(tempCnt)
                tempCnt = 1
            }
            else tempCnt++
        }
        answer.add(tempCnt)
        return answer.toIntArray()
    }
}

fun main() {
    Pr42586().apply {
//        println(
//            solution(
//                intArrayOf(93, 30, 55),
//                intArrayOf(1, 30, 5)
//            ).contentToString()
//        )
//        println(
//            solution(
//                intArrayOf(95, 90, 99, 99, 80, 99),
//                intArrayOf(1, 1, 1, 1, 1, 1)
//            ).contentToString()
//        )
        println(
            solution(
                intArrayOf(95, 95, 95, 95),
                intArrayOf(4, 3, 2, 1)
            ).contentToString()
        )
    }
}