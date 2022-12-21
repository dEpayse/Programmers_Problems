package lv1

class Pr82612 {
    fun solution(price: Int, money: Int, count: Int): Long {
        val currentMoney = money.toLong()
        val totalPrice = (1..count).sumOf { it.toLong() * price.toLong() }
        val moneyNeeded = totalPrice - currentMoney
        if(moneyNeeded < 0) return 0
        return moneyNeeded
    }
}

fun main() {
    Pr82612().apply {
        println(solution(3, 20, 4))
    }
}