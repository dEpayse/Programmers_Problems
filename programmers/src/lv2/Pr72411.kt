package lv2

import java.util.*

// https://school.programmers.co.kr/learn/courses/30/lessons/72411
class Pr72411 {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val candidates = hashMapOf<String, Int>()

        orders.forEach {
            bruteForceCombination(orders, course, it.toList(), 0, BooleanArray(it.length) { false }, LinkedList(), 0, candidates)
        }
        val courseMap = hashMapOf<Int, MutableList<String>>().apply {
            candidates.keys.map { it.length }.toSet().forEach {
                set(it, mutableListOf())
            }
        }
        val courseMaxCntMap = hashMapOf<Int, Int>().apply {
            candidates.forEach {
                if(get(it.key.length) != null) {
                    if(get(it.key.length)!! < it.value) set(it.key.length, it.value)
                    return@forEach
                }
                set(it.key.length, it.value)
            }
        }
        candidates.forEach {
            if(it.value == courseMaxCntMap[it.key.length]) courseMap[it.key.length]?.add(it.key)
        }

        return courseMap.values.flatten().sorted().toTypedArray()
    }

    private fun bruteForceCombination(
        orders: Array<String>,
        course: IntArray,
        menuList: List<Char>,
        startIdx: Int,
        visited: BooleanArray,
        combination: LinkedList<Char>,
        depth: Int,
        candidatesMap: HashMap<String, Int>
    ) {
        (startIdx..menuList.lastIndex).forEach { idx ->
            if(!visited[idx]){
                visited[idx] = true
                combination.add(menuList[idx])
                if(combination.size >= course.first() && course.contains(combination.size)) {
                    val combinationCnt = orders.toList().count { it.toList().containsAll(combination) }
                    if(combinationCnt > 1) {
                        candidatesMap[combination.sorted().joinToString("")] = combinationCnt
                    }
                }
                if(combination.size < course.last()) bruteForceCombination(orders, course, menuList, idx, visited, combination, depth + 1, candidatesMap)
                visited[idx] = false
                combination.removeLast()
            }
        }
    }
}

fun main() {
    Pr72411().apply {
        println(
            solution(
                arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"),
                intArrayOf(2, 3, 4, 5)
            ).contentToString()
        )
        println(
            solution(
                arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"),
                intArrayOf(2, 3, 5)
            ).contentToString()
        )
        println(
            solution(
                arrayOf("XYZ", "XWY", "WXA"),
                intArrayOf(2, 3, 4)
            ).contentToString()
        )
        println(
            solution(
                arrayOf("ABCD", "ABCD", "ABCD"),
                intArrayOf(2,3,4)
            ).contentToString()
        )
    }
}