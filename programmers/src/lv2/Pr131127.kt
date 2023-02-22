package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
class Pr131127 {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val wantMap = hashMapOf<String, Int>().apply {
            want.indices.forEach { idx ->
                set(want[idx], number[idx])
            }
        }
        return discount.toList().windowed(10)
            .map { it.groupBy { it1 -> it1 }.mapValues { it1 -> it1.value.size } }
            .count { discountEntry ->
                wantMap.all { wantEntry ->
                    wantEntry.value == discountEntry.getOrDefault(wantEntry.key, 0)
                }
            }
    }
}

fun main() {
    Pr131127().apply {
        println(
            solution(
                arrayOf("banana", "apple", "rice", "pork", "pot"),
                intArrayOf(3, 2, 2, 2, 1),
                arrayOf(
                    "chicken",
                    "apple",
                    "apple",
                    "banana",
                    "rice",
                    "apple",
                    "pork",
                    "banana",
                    "pork",
                    "rice",
                    "pot",
                    "banana",
                    "apple",
                    "banana"
                )
            )
        )
        println(
            solution(
                arrayOf("apple"),
                intArrayOf(10),
                arrayOf(
                    "banana",
                    "banana",
                    "banana",
                    "banana",
                    "banana",
                    "banana",
                    "banana",
                    "banana",
                    "banana",
                    "banana"
                )
            )
        )
    }
}