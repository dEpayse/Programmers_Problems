package lv2

class Pr43165 {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        ((Math.pow(2.toDouble(), numbers.size.toDouble()).toInt() - 1) downTo 0).forEach {
            val multiplyList = String.format("%${numbers.size}s", it.toString(2)).map { binary -> if(binary == '1') -1 else 1 }
            val sum = numbers.foldIndexed(0) { idx, acc, num -> acc + num * multiplyList[idx] }
            if(sum == target) answer++
        }
        return answer
    }
    fun solution2(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { list, i ->
            println(list)
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }
}

fun main() {
    Pr43165().apply {
        println(
            solution2(
                intArrayOf(1, 1, 1, 1, 1),
                3
            )
        )
        println(
            solution2(
                intArrayOf(4, 1, 2, 1),
                4
            )
        )
    }
}