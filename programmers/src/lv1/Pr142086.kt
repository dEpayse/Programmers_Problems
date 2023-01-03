package lv1

import printIntArray

class Pr142086 {
    fun solution(s: String): IntArray =
        s.mapIndexed { idx, it ->
            val findIdx = s.substring(0, idx).indexOfLast { it1 -> it == it1 }
            if (findIdx != -1) idx - findIdx
            else -1
        }.toIntArray()
}

fun main() {
    Pr142086().apply {
        printIntArray(solution("banana"))
        printIntArray(solution("foobar"))
    }
}