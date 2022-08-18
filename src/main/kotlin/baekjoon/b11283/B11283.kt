package baekjoon.b11283

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine()[0]
    val answer = n - '가' + 1
    bw.write("$answer")
    bw.close()
    br.close()
}