package lv1

class Pr118666 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val scoreList = linkedMapOf(
            'R' to 0,
            'T' to 0,
            'C' to 0,
            'F' to 0,
            'J' to 0,
            'M' to 0,
            'A' to 0,
            'N' to 0
        )
        val characterPairList = scoreList.keys.chunked(2).map { Pair(it[0], it[1]) }

        choices.zip(survey).forEach { (choice, surveyElem) ->
            when {
                choice < 4 -> {
                    scoreList[surveyElem[0]] = scoreList.getValue(surveyElem[0]) + 4 - choice
                }
                choice > 4 -> {
                    scoreList[surveyElem[1]] = scoreList.getValue(surveyElem[1]) + choice - 4
                }
            }
        }

        return characterPairList.map { (firstChar, secondChar) ->
            if (scoreList.getValue(firstChar) < scoreList.getValue(secondChar)) secondChar
            else firstChar
        }.joinToString("")
    }
}

fun main() {
    Pr118666().apply {
        println(
            solution(
                arrayOf("AN", "CF", "MJ", "RT", "NA"),
                intArrayOf(5, 3, 2, 7, 5)
            )
        )

        println(
            solution(
                arrayOf("TR", "RT", "TR"),
                intArrayOf(7, 1, 3)
            )
        )
    }
}