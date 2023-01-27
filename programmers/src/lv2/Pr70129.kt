package lv2

class Pr70129 {
    fun solution(s: String): IntArray  {
        var tempStr = s
        var transitionCnt = 0
        var erasedZeroCnt = 0
        while(tempStr != "1") {
            tempStr = tempStr.filter {
                if(it=='0') erasedZeroCnt++
                it != '0'
                }
                .length.toString(2)
            transitionCnt++
        }
        return intArrayOf(transitionCnt, erasedZeroCnt)
    }
}

fun main() {
    Pr70129().apply {
        println(solution("110010101001").contentToString())
        println(solution("01110").contentToString())
        println(solution("1111111").contentToString())
    }
}