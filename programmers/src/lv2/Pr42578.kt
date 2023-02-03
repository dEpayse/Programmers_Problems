package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/42578
class Pr42578 {
    fun solution(clothes: Array<Array<String>>): Int =
        clothes.groupBy { it[1] }
            .map { it.value.size + 1 }
            .reduce { acc, it -> acc * it } - 1
}

fun main() {
    Pr42578().apply {
        println(
            solution(
                arrayOf(
                    arrayOf(
                        "yellow_hat",
                        "headgear"
                    ),
                    arrayOf(
                        "blue_sunglasses",
                        "eyewear"
                    ),
                    arrayOf(
                        "green_turban",
                        "headgear"
                    )
                )
            )
        )
        println(
            solution(
                arrayOf(
                    arrayOf(
                        "crow_mask",
                        "face"
                    ),
                    arrayOf(
                        "blue_sunglasses",
                        "face"
                    ),
                    arrayOf(
                        "smoky_makeup",
                        "face"
                    )
                )
            )
        )
    }
}