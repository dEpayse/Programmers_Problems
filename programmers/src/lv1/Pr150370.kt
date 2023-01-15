package lv1

import printIntArray

class Pr150370 {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val todayDate = today.split(".").let {
            Date(
                it[0].toInt(),
                it[1].toInt(),
                it[2].toInt(),
            )
        }
        val termsMap = mutableMapOf<String, Int>().apply {
            terms.forEach {
                it.split(" ").also { it1 ->
                    set(
                        it1[0],
                        it1[1].toInt()
                    )
                }
            }
        }
        privacies.forEachIndexed { idx, it ->
            val (dateStr, term) = it.split(" ")
            val collectedDate = dateStr.split(".").let {
                Date(
                    it[0].toInt(),
                    it[1].toInt(),
                    it[2].toInt()
                )
            }
            if(collectedDate.addMonth(termsMap.getValue(term)) < todayDate) answer.add(idx + 1)
        }
        return answer.toIntArray()
    }
}

data class Date(val year: Int, val month: Int, val dayOfMonth: Int) {
    fun addMonth(inputMonth: Int): Date {
        val addedMonth = month + inputMonth - 1
        return Date(year + addedMonth / 12, addedMonth % 12 + 1, dayOfMonth).minusOneDay()
    }

    private fun minusOneDay() : Date {
        if(dayOfMonth-1==0) {
            if(month-1==0) {
                return Date(year-1, 12 , 28)
            }
            return Date(year, month - 1, 28)
        }
        else {
            return Date(year, month, dayOfMonth - 1)
        }
    }

    operator fun compareTo(date: Date): Int =
        if(year > date.year) {
            1
        }
        else if(year < date.year) {
            -1
        }
        else {
            if(month > date.month) {
              1
            }
            else if(month < date.month) {
                -1
            }
            else {
                dayOfMonth.compareTo(date.dayOfMonth)
            }
        }
}

fun main() {
    Pr150370().apply {
        printIntArray(
            solution(
                "2022.05.19",
                arrayOf("A 6", "B 12", "C 3"),
                arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
            )
        )
        printIntArray(
            solution(
                "2020.01.01",
                arrayOf("Z 3", "D 5"),
                arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
            )
        )
    }
}