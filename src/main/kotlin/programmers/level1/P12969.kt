package programmers.level1

// 직사각형 별찍기

fun main() {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)

    for (i in 0 until m) {
        for (j in 0 until n) {
            print("*")
        }
        println()
    }
}