package lv2

class Pr42746 {
    fun solution(numbers: IntArray): String =
        numbers.map { it.toString() }
            .sortedWith { o1, o2 -> getComparedResult(o1, o2) }
            .joinToString("")
            .let {
                if(it.all { it1 -> it1 == '0'}) "0"
                else it
            }


    private fun getComparedResult(o1: String, o2: String) : Int {
        val zipped = o1.zip(o2)
        return if(zipped.all { it.first == it.second }) {
            if(o1.length > o2.length) {
                getComparedResult(o1.replaceFirst(o2, ""), o2)
            }
            else if(o1.length < o2.length) {
                getComparedResult(o1, o2.replaceFirst(o1, ""))
            }
            else 0
        }
        else {
            val firstDiff = zipped.find { it.first != it.second }
            firstDiff?.second?.compareTo(firstDiff.first)!!
        }
    }
}

fun main() {
    Pr42746().apply {
        println(solution(intArrayOf(6, 10, 2)))
        println(solution(intArrayOf(3, 30, 34, 5, 9)))
        println(solution(intArrayOf(1, 10, 100, 1000, 818, 81, 898, 89, 0, 0)))
    }
}