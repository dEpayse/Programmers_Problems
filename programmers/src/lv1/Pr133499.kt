package lv1

class Pr133499 {
    fun solution(babbling: Array<String>): Int =
        babbling.count { elem ->
            val canPronounce = arrayOf("aya", "ye", "woo", "ma")
            canPronounce.forEach {
                if(elem.contains("$it$it")) return@count false
            }
            var remain = elem
            canPronounce.forEachIndexed { idx, it ->
                remain = remain.replace(it, "*")
            }
            remain.replace("*","")
                .isEmpty()
        }
}

fun main() {
    Pr133499().apply {
        println(solution(arrayOf("aya", "yee", "u", "maa")))
        println(solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")))
    }
}