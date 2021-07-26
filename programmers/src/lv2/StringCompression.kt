package lv2

fun main() {
    println(solution("aabbaccc"))
    println(solution("ababcdcdababcdcd"))
    println(solution("abcabcdede"))
    println(solution("abcabcabcabcdededededede"))
    println(solution("xababcdcdababcdcd"))
    //100xz => 5 나와야 함
    println(solution("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxz"))
}

fun solution(s: String): Int {
    var min = Int.MAX_VALUE
    if (s.length == 1) return 1
    for (i in 1..s.length / 2) {
        var start = 0
        var tempStr = ""
        var length = 0
        var count = 1
        while (start < s.length) {
            val subStr: String =
                if (start + i < s.length) s.substring(start, start + i)
                else s.substring(start, s.length)


            //마지막일 때 처리
            if (start + i >= s.length) {
                // 처음이 마지막일 때
                if (start == 0) {
                    length += subStr.length
                    start += i
                    if (length < min) min = length
                }
                length +=
                    // 마지막인데 tempStr과 subStr이 같을 때
                    if (tempStr == subStr) {
                        count++
                        (tempStr.length + count.toString().length)
                    }
                    // 마지막인데 tempStr과 subStr이 다를 때
                    else {
                        // tempStr이 반복되지 않았을 때
                        if (count == 1) {
                            (tempStr.length + subStr.length)
                        }
                        // tempStr이 연속으로 두 번 이상 나오면 숫자까지 글자 수에 들어가야 함
                        else {
                            (count.toString().length + tempStr.length + subStr.length)
                        }
                    }
                break
            }

            //처음 시작할 때 처리
            if (start == 0) {
                tempStr = subStr
                start += i
                continue
            }

            // 처음이거나 마지막이 아니고, tempStr이 subStr과 같을 때
            if (tempStr == subStr) {
                count++
            }
            // 처음이거나 마지막이 아니고, tempStr이 subStr과 다를 때
            else {
                // 다른데 반복이 없을 때
                if (count == 1) {
                    length += tempStr.length
                }
                // 다른데 반복됐을 때
                else {
                    length += (tempStr.length + count.toString().length)
                    count = 1
                }
                tempStr = subStr
            }
            start += i
        }
        if (length < min) min = length
    }
    return min
}