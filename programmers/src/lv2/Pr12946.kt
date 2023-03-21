package lv2

class Pr12946 {
    fun solution(n: Int): Array<IntArray> = moveDisks(n, 1, 3)

    private fun moveDisks(n: Int, from: Int, to: Int): Array<IntArray> {
        if(n==1) return arrayOf(intArrayOf(from, to))
        val left = mutableSetOf(1,2,3).apply {
            remove(from)
            remove(to)
        }.first()
        return moveDisks(n-1, from, left) + arrayOf(intArrayOf(from, to)) + moveDisks(n-1, left, to)
    }
}

fun main() {
    Pr12946().apply {
        println(solution(2).contentDeepToString())
    }
}
