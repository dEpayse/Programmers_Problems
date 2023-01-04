package lv1

class Pr42862 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val clothesList = IntArray(n) { 1 }
            .mapIndexed { idx, i ->
                var clothesCnt = i
                if (lost.contains(idx + 1)) clothesCnt--
                if (reserve.contains(idx + 1)) clothesCnt++
                clothesCnt
            }.toMutableList()
        for (idx in clothesList.indices) {
            if (clothesList[idx] == 0) {
                if (idx - 1 >= 0) {
                    if (clothesList[idx - 1] > 1) {
                        clothesList[idx]++
                        clothesList[idx - 1]--
                        continue
                    }
                }
                if (idx + 1 <= clothesList.lastIndex) {
                    if (clothesList[idx + 1] > 1) {
                        clothesList[idx]++
                        clothesList[idx + 1]--
                        continue
                    }
                }
            }
        }
        return clothesList.count { it > 0 }
    }

    fun solution2(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n
        val lostSet = lost.toSortedSet() - reserve.toSortedSet()
        val reserveSet = (reserve.toSortedSet() - lost.toSortedSet()).toMutableSet()

        for (i in lostSet) {
            when {
                i - 1 in reserveSet -> reserveSet.remove(i - 1)
                i + 1 in reserveSet -> reserveSet.remove(i + 1)
                else -> answer--
            }
        }

        return answer
    }
}

fun main() {
    Pr42862().apply {
        println(
            solution2(
                5, intArrayOf(2, 4),
                intArrayOf(1, 3, 5)
            )
        )

        println(
            solution2(
                5, intArrayOf(2, 4),
                intArrayOf(3)
            )
        )

        println(
            solution(
                3, intArrayOf(3),
                intArrayOf(1)
            )
        )

        println(
            solution(
                4,
                intArrayOf(2, 4),
                intArrayOf(1, 3),
            )
        )
    }
}