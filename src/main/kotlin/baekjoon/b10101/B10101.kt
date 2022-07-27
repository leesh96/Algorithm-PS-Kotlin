package baekjoon.b10101

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()

    val sum = a + b + c
    val answer = when {
        a == 60 && b == 60 && c == 60 -> "Equilateral"
        sum == 180 && (a == b || b == c || a == c) -> "Isosceles"
        sum == 180 && (a != b && b != c && a != c) -> "Scalene"
        else -> "Error"
    }

    bw.write("$answer")
    bw.close()
    br.close()
}