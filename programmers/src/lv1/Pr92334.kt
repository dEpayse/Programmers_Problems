package lv1

import printIntArray

class Pr92334 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportedCntMap = linkedMapOf<String, Int>().apply {
            id_list.forEach {
                set(it, 0)
            }
        }
        val reportMap = mutableMapOf<String, MutableSet<String>>().apply {
            id_list.forEach {
                set(it, mutableSetOf())
            }
            report.forEach {
                val (reporter, reportedUser) = it.split(" ")
                if(!getValue(reporter).contains(reportedUser)) {
                    reportedCntMap[reportedUser] = reportedCntMap.getValue(reportedUser) + 1
                    getValue(reporter).add(reportedUser)
                }
            }
        }
        return reportMap.map { (_, reportedUserSet) ->
            reportedUserSet.count { reportedCntMap.getValue(it) >= k }
        }.toIntArray()
    }
}

fun main() {
    Pr92334().apply {
        printIntArray(
            solution(
                arrayOf("muzi", "frodo", "apeach", "neo"),
                arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),
                2
            )
        )
        printIntArray(
            solution(
                arrayOf("con", "ryan"),
                arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
                3
            )
        )
    }
}