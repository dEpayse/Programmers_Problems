package lv2

import kotlin.math.ceil

fun main() {
    printIntArray(solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)))
    printIntArray(solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1)))
    printIntArray(solution(intArrayOf(20, 99, 93, 30, 55, 10), intArrayOf(5, 10, 1, 1, 30, 5)))
}

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = intArrayOf()

    var tempTime = 0
    var cnt = 0

    // 이번엔 Sequence 를 이용하였지만, 이 문제의 경우 Sequence 를 이용하지 않아도 시간 차이는 없었을 것이다.
    // 헷갈리는 경우는 처음 경우랑 마지막 경우였는데,
    // 마지막인 경우는 그냥 루프가 끝나고 밖에서 한 번 더 더해주는 방법을 이용하면 훨씬 간단해졌고,
    // 처음인 경우는 다른 조건과 비교해서 다른 점만 적용해주는 방법을 이용하면 좋다.
    progresses
        .mapIndexed { idx, progress -> (100 - progress) / speeds[idx].toDouble() }
        .map { ceil(it).toInt() }
        .asSequence()
        .forEach { curTime ->
            println(curTime)
            if (tempTime >= curTime) {
                cnt++
            }
            else {
                if (tempTime !=0) answer += cnt
                tempTime = curTime
                cnt = 1
            }
        }
    answer += cnt

    return answer
}


fun printIntArray(intArray: IntArray) {
    print("[")
    for ((index, i) in intArray.withIndex()) {
        if (index == intArray.lastIndex) print("$i")
        else print("$i, ")
    }
    println("]")
}