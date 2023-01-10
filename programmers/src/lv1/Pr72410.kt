package lv1

class Pr72410 {
    fun solution(new_id: String): String {
        return new_id
            .lowercase()
            .replace("[^a-z\\d-_.]".toRegex(),"")
            .replace("[.]{2,}".toRegex(), ".")
            .replace("^[.]".toRegex(),"")
            .replace("[.]$".toRegex(),"")
            .let {
                it.ifEmpty { "a" }
            }
            .let {
                if(it.length>15) it.substring(0, 15)
                else it
            }
            .replace("[.]$".toRegex(),"")
            .let {
                if(it.length<=2) {
                    val strBuilder = StringBuilder(it)
                    while(strBuilder.length<3) {
                        strBuilder.append(strBuilder.last())
                    }
                    strBuilder.toString()
                }
                else it
            }
    }
}

fun main() {
    Pr72410().apply {
        println(solution("...!@BaT#*..y.abcdefghijklm"))
        println(solution("z-+.^."))
        println(solution("=.="))
        println(solution("123_.def"))
        println(solution("abcdefghijklmn.p"))
    }
}