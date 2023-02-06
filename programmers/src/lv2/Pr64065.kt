package lv2

class Pr64065 {
    fun solution(s: String): IntArray {
        val answer = mutableSetOf<Int>()
        s.split("},")
            .map {
                it.trim('{', '}').split(",").map {it1 ->
                    it1.toInt()
                }
            }
            .sortedBy { it.size }
            .forEach {
                it.forEach addScope@ { it1 ->
                    if(answer.add(it1)) return@addScope
                }
            }
        return answer.toIntArray()
    }
}

fun main() {
    Pr64065().apply {
        println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}").contentToString())
        println(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}").contentToString())
        println(solution("{{20,111},{111}}").contentToString())
        println(solution("{{123}}").contentToString())
        println(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}").contentToString())
    }
}