package lv1

class Pr12943 {
    fun solution(num: Int): Int {
        var cnt = 0
        var nextValue = num.toLong()
        while(collatz(nextValue, cnt) != -1L && nextValue != 1L) {
            nextValue = collatz(nextValue, cnt)
            cnt++
        }

        return if(cnt >= 500) -1
        else cnt
    }

    private fun collatz(x: Long, cnt: Int): Long {
        if(x == 1L) return -1
        if(cnt >= 500) return -1
        return if(x % 2 == 0L) x / 2
        else x * 3 + 1
    }

    // Int 형의 overflow 를 감지하는 함수 사용 예시
    private fun collatz(x: Int, cnt: Int): Int {
        if(x == 1) return  -1
        if(cnt >= 500) return -1
        return if(x % 2 == 0) x / 2
        else Math.addExact(Math.multiplyExact(x,3), 1)
    }
}

fun main() {
    Pr12943().apply {
        println(solution(6))
        println(solution(16))
        println(solution(626331))
    }
}