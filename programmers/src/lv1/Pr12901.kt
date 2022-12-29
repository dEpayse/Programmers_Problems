package lv1

import java.util.*

class Pr12901 {
    fun solution(a: Int, b: Int): String {
        val dayOfWeek =
            Calendar.getInstance().apply {
                set(2016, a - 1, b)
            }.get(Calendar.DAY_OF_WEEK)
        return when (dayOfWeek) {
            Calendar.SUNDAY -> "SUN"
            Calendar.MONDAY -> "MON"
            Calendar.TUESDAY -> "TUE"
            Calendar.WEDNESDAY -> "WED"
            Calendar.THURSDAY -> "THU"
            Calendar.FRIDAY -> "FRI"
            else -> "SAT"
        }
    }

    fun solution2(a: Int, b: Int): String {
        val dayOfWeekList = listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        val lastDaysList = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        val calculatedDays = lastDaysList.subList(0, a - 1).sum() + b
        return dayOfWeekList[(calculatedDays + 4) % 7]
    }
}

fun main() {
    Pr12901().apply {
        println(solution(5, 24))
        println(solution2(5, 24))
    }
}