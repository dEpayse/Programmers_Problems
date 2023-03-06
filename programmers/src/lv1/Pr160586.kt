package lv1

// https://school.programmers.co.kr/learn/courses/30/lessons/160586
class Pr160586 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val minPushCntMap = hashMapOf<Char, Int>()
        keymap.forEach { key ->
            key.forEachIndexed { idx, it ->
                if(minPushCntMap[it] == null) {
                    minPushCntMap[it] = idx + 1
                    return@forEachIndexed
                }
                if(idx + 1 < minPushCntMap[it]!!) {
                    minPushCntMap[it] = idx + 1
                    return@forEachIndexed
                }
            }
        }
        return targets.map {
            it.sumOf { char ->
                if(minPushCntMap[char] == null) return@map -1
                minPushCntMap[char]!!
            }
        }.toIntArray()
    }
}

fun main() {
    Pr160586().apply {
        println(
            solution(
                arrayOf("ABACD", "BCEFD"),
                arrayOf("ABCD","AABB")
            ).contentToString()
        )
        println(
            solution(
                arrayOf("AA"),
                arrayOf("B")
            ).contentToString()
        )
        println(
            solution(
                arrayOf("AGZ", "BSSS"),
                arrayOf("ASA","BGZ")
            ).contentToString()
        )
    }
}