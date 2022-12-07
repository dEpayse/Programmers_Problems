package lv1

class Pr12944 {
    fun solution(arr: IntArray): Double = arr.average()
}

fun main() {
    Pr12944().apply {
        println(solution(intArrayOf(1,2,3,4)))
        println(solution(intArrayOf(5,5)))
    }
    println("5 op 3: positive dividend, positive divisor")
    println("mod: ${5.mod(3)}")
    println(" % : ${5 % 3}")
    println("rem: ${5.rem(3)}")
    println()
    println("5 op (-3): positive dividend, negative divisor")
    println("mod: ${5.mod(-3)}")
    println(" % : ${5 % (-3)}")
    println("rem: ${5.rem(-3)}")
    println()
    println("(-5) op 3: negative dividend, positive divisor")
    println("mod: ${(-5).mod(3)}")
    println(" % : ${(-5) % 3}")
    println("rem: ${(-5).rem(3)}")
    println()
    println("(-5) op (-3): negative dividend, negative divisor")
    println("mod: ${(-5).mod(-3)}")
    println(" % : ${(-5) % (-3)}")
    println("rem: ${(-5).rem(-3)}")
}