package lv1

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
class Pr161990 {
    fun solution(wallpaper: Array<String>): IntArray {
        val answer: IntArray = intArrayOf(
            Int.MAX_VALUE,
            Int.MAX_VALUE,
            Int.MIN_VALUE,
            Int.MIN_VALUE
        )
        wallpaper.forEachIndexed { yIdx, rowElem ->
            rowElem.forEachIndexed { xIdx, colElem ->
                if(colElem == '#') {
                    if(yIdx < answer[0]) answer[0] = yIdx
                    if(xIdx < answer[1]) answer[1] = xIdx
                    if(yIdx + 1 > answer[2]) answer[2] = yIdx + 1
                    if(xIdx + 1 > answer[3]) answer[3] = xIdx + 1
                }
            }
        }
        return answer
    }
}

fun main() {
    Pr161990().apply {
        println(
            solution(
                arrayOf(".#...", "..#..", "...#.")
            ).contentToString()
        )
        println(
            solution(
                arrayOf("..........", ".....#....", "......##..", "...##.....", "....#.....")
            ).contentToString()
        )
        println(
            solution(
                arrayOf(".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#....")
            ).contentToString()
        )
        println(
            solution(
                arrayOf("..", "#.")
            ).contentToString()
        )
    }
}