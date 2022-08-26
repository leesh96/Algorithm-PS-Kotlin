package baekjoon.b15439

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val answer = n * (n - 1)
    bw.write("$answer")
    bw.close()
    br.close()
}