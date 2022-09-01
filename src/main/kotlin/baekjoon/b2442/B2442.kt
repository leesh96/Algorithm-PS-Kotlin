package baekjoon.b2442

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()

    for (i in 1..n) {
        for (j in 0 until n - i) {
            bw.write(" ")
        }
        for (k in 0 until 2 * i - 1) {
            bw.write("*")
        }
        bw.newLine()
    }
    bw.close()
    br.close()
}