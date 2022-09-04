package baekjoon.b10953

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()
    repeat(t) {
        val answer = br.readLine().split(",").map { it.toInt() }.sumOf { it }
        bw.write("$answer")
        bw.newLine()
    }
    bw.close()
    br.close()
}