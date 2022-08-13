package baekjoon.b11282

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val answer = (n + 44031).toChar()

    bw.write("$answer")
    bw.close()
    br.close()
}