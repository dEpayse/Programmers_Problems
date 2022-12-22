package lv1

fun main() {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    repeat(b) {
        repeat(a) {
            print("*")
        }
        println("")
    }
}
