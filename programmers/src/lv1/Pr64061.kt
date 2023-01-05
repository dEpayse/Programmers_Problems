package lv1


import java.util.Stack
class Pr64061 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val stack = Stack<Int>()
        var answer = 0
        moves.forEach outer@{ crainPos ->
            (0..board.lastIndex).forEach { idx ->
                val doll = board[idx][crainPos - 1]
                if (doll == 0) return@forEach
                else {
                    if(stack.pushDoll(doll)) answer += 2
                    board[idx][crainPos - 1] = 0
                    return@outer
                }
            }
        }
        return answer
    }

    private fun <T> Stack<T>.pushDoll(doll: T): Boolean {
        if (empty()) {
            push(doll)
            return false
        }
        if (peek() == doll) {
            pop()
            return true
        }
        push(doll)
        return false
    }
}

fun main() {
    Pr64061().apply {
        println(
            solution(
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 1, 0, 3),
                    intArrayOf(0, 2, 5, 0, 1),
                    intArrayOf(4, 2, 4, 4, 2),
                    intArrayOf(3, 5, 1, 3, 1)
                ),
                intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
            )
        )
    }
}