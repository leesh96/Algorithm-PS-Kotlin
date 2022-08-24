package baekjoon.b14935

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val x = br.readLine()
    bw.write("FA")
    bw.close()
    br.close()
}

private fun solution(x: String): Int {
    return x[0].digitToInt() * x.length
}