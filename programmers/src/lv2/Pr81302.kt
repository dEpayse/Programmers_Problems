package lv2

//https://school.programmers.co.kr/learn/courses/30/lessons/81302
class Pr81302 {
    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(places.size) { 1 }
        places.forEachIndexed { placeIdx, place ->
            placeLoop@ for (rowIdx in place.indices) {
                for (colIdx in 0 until place[rowIdx].length) {
                    if (place[rowIdx][colIdx] != 'P') continue
                    if (rowIdx + 1 < place.size && place[rowIdx + 1][colIdx] == 'P') {
                        answer[placeIdx] = 0
                        break@placeLoop
                    }
                    if (rowIdx + 2 < place.size && place[rowIdx + 2][colIdx] == 'P') {
                        if (place[rowIdx + 1][colIdx] != 'X') {
                            answer[placeIdx] = 0
                            break@placeLoop
                        }
                    }
                    if (colIdx + 1 < place[rowIdx].length && place[rowIdx][colIdx + 1] == 'P') {
                        answer[placeIdx] = 0
                        break@placeLoop
                    }
                    if (colIdx + 2 < place[rowIdx].length && place[rowIdx][colIdx + 2] == 'P') {
                        if (place[rowIdx][colIdx + 1] != 'X') {
                            answer[placeIdx] = 0
                            break@placeLoop
                        }
                    }
                    if (rowIdx + 1 < place.size && colIdx + 1 < place[rowIdx].length && place[rowIdx + 1][colIdx + 1] == 'P') {
                        if (place[rowIdx + 1][colIdx] != 'X' || place[rowIdx][colIdx + 1] != 'X') {
                            answer[placeIdx] = 0
                            break@placeLoop
                        }
                    }
                    if (rowIdx + 1 < place.size && colIdx - 1 >= 0 && place[rowIdx + 1][colIdx - 1] == 'P') {
                        if (place[rowIdx + 1][colIdx] != 'X' || place[rowIdx][colIdx - 1] != 'X') {
                            answer[placeIdx] = 0
                            break@placeLoop
                        }
                    }
                }
            }
        }
        return answer
    }
}

fun main() {
    Pr81302().apply {
        println(
            solution(
                arrayOf(
                    arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
                    arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
                    arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
                    arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
                    arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
                )
            ).contentToString()
        )
    }
}