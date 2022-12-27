package lv1

class Pr12915 {
    fun solution(strings: Array<String>, n: Int): Array<String> =
        strings.sortedWith { o1, o2 ->
            if(o1[n] > o2[n]) 1
            else if(o1[n] < o2[n]) -1
            else o1.compareTo(o2)
        }.toTypedArray()
}

fun main() {
    Pr12915().apply {
        solution(
            arrayOf("sun", "bed", "car"), 1
        ).forEach {
            print("${it}, ")
        }
        println()
        solution(
            arrayOf("abce", "abcd", "cdx"), 2
        ).forEach {
            print("${it}, ")
        }
    }
}