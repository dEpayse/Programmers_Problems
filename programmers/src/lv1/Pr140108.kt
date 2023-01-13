package lv1

class Pr140108 {
    fun solution(s: String): Int {
        var answer = 0
        var remain = s
        var sameCharCnt = 0
        var diffCharCnt = 0
        while(remain.isNotEmpty()) {
            answer++
            val firstChar = remain[0]
            var pointIdx = remain.length
            for(index in remain.indices) {
                if((sameCharCnt != 0 || diffCharCnt != 0) && sameCharCnt == diffCharCnt) {
                    pointIdx = index
                    break
                }
                if(remain[index] == firstChar) sameCharCnt++
                else diffCharCnt++
            }
            sameCharCnt = 0
            diffCharCnt = 0
            remain =
                if(remain.lastIndex >= pointIdx) remain.substring(pointIdx)
                else ""
            println(remain)
        }
        return answer
    }
}

fun main() {
    Pr140108().apply {
        println(solution("banana"))
        println(solution("abracadabra"))
        println(solution("aaabbaccccabba"))
    }
}