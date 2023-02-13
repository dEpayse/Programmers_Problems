package lv2

class Pr131701 {
    fun solution(elements: IntArray): Int {
        val answerSet = mutableSetOf<Int>()
        (1..elements.size).forEach { cnt ->
            elements.indices.forEach { idx ->
                var tempIdx = idx
                var sum = 0
                repeat(cnt) {
                    sum += elements[tempIdx]
                    tempIdx = increasedIdx(tempIdx, elements.lastIndex)
                }
                answerSet.add(sum)
            }
        }
        return answerSet.size
    }

    private fun increasedIdx(idx: Int, lastIdx: Int): Int {
        return if (idx+1 > lastIdx) 0
        else idx + 1
    }
}

fun main() {
    Pr131701().apply {
        println(solution(intArrayOf(7, 9, 1, 1, 4)))
    }
}