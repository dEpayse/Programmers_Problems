package lv1

class Pr76501 {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int = absolutes.mapIndexed { index, i -> if(!signs[index]) i.unaryMinus() else i }.sum()
}

fun main() {
    Pr76501().apply {
        println(solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true)))
        println(solution(intArrayOf(1, 2, 3), booleanArrayOf(false, false, true)))
    }
}