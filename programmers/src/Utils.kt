
fun printIntArray(intArray: IntArray) {
    print("[")
    for ((index, i) in intArray.withIndex()) {
        if (index == intArray.lastIndex) print("$i")
        else print("$i, ")
    }
    println("]")
}