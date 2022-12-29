package lv1

import printIntArray

class Pr42480 {
    fun solution(answers: IntArray): IntArray {
        fun LinkedHashMap<Int, Int>.scoring(key: Int) {
            set(key, getValue(key).plus(1))
        }

        val linkedMap = linkedMapOf(1 to 0, 2 to 0, 3 to 0).apply {
            answers.forEachIndexed { idx, i ->
                if (idx % 5 + 1 == i) scoring(1)

                if (idx % 2 == 0) {
                    if (i == 2) scoring(2)
                } else {
                    when (idx / 2 % 4) {
                        0 -> if (i == 1) scoring(2)
                        1 -> if (i == 3) scoring(2)
                        2 -> if (i == 4) scoring(2)
                        3 -> if (i == 5) scoring(2)
                    }
                }

                when (idx / 2 % 5) {
                    0 -> if (i == 3) scoring(3)
                    1 -> if (i == 1) scoring(3)
                    2 -> if (i == 2) scoring(3)
                    3 -> if (i == 4) scoring(3)
                    4 -> if (i == 5) scoring(3)
                }
            }
        }

        val max = linkedMap.maxOf { (_, value) -> value }

        return linkedMap.filterValues {
            it == max
        }.keys.toIntArray()
    }

    fun solution2(answers: IntArray): IntArray {
        val submittedAnswersMap = linkedMapOf(
            1 to listOf(1, 2, 3, 4, 5),
            2 to listOf(2, 1, 2, 3, 2, 4, 2, 5),
            3 to listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )

        val correctedAnswersCntMap = linkedMapOf(
            1 to 0,
            2 to 0,
            3 to 0
        )

        answers.forEachIndexed { idx, i ->
            fun scoring(person: Int) {
                if (i == submittedAnswersMap.getValue(person)[idx % submittedAnswersMap.getValue(person).size])
                    correctedAnswersCntMap[person] = correctedAnswersCntMap.getValue(person) + 1
            }
            (1..3).forEach {
                scoring(it)
            }
        }

        val max = correctedAnswersCntMap.maxOf { (_, value) -> value }

        return correctedAnswersCntMap.filterValues {
            it == max
        }.keys.toIntArray()
    }


}

fun main() {
    Pr42480().apply {
        printIntArray(solution(intArrayOf(1, 2, 3, 4, 5)))
        printIntArray(solution(intArrayOf(1, 3, 2, 4, 2)))

        printIntArray(solution2(intArrayOf(1, 2, 3, 4, 5)))
        printIntArray(solution2(intArrayOf(1, 3, 2, 4, 2)))
    }
}