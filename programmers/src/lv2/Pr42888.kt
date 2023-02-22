package lv2

// https://school.programmers.co.kr/learn/courses/30/lessons/42888
class Pr42888 {
    fun solution(record: Array<String>): Array<String> {
        val idToFinalNicknameMap = record.map { Record.getObjFromStr(it) }
            .groupBy { it.id }
            .mapValues { (_, recordList) ->
                recordList
                    .findLast { it.command == "Change" || it.command == "Enter" }
                    ?.nickname
            }
        return record.map { Record.getObjFromStr(it) }
            .filterNot {it.command == "Change" }
            .map {
                "${idToFinalNicknameMap[it.id]}${it.commandGuide}"
            }
            .toTypedArray()
    }

    data class Record(
        val command: String,
        val id: String,
        val nickname: String? = null
    ) {
        companion object {
            fun getObjFromStr(str: String): Record {
                val splitList = str.split(" ")
                return if (splitList.size == 3) Record(splitList[0], splitList[1], splitList[2])
                else Record(splitList[0], splitList[1])
            }
        }

        val commandGuide = if(command=="Enter") "님이 들어왔습니다." else "님이 나갔습니다."
    }
}

fun main() {
    Pr42888().apply {
        println(
            solution(
                arrayOf(
                    "Enter uid1234 Muzi",
                    "Enter uid4567 Prodo",
                    "Leave uid1234",
                    "Enter uid1234 Prodo",
                    "Change uid4567 Ryan"
                )
            ).contentToString()
        )
    }
}