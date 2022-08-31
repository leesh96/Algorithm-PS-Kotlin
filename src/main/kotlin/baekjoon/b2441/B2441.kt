package baekjoon.b2441

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()

    for (i in 0 until n) {
        for (j in 0 until i) {
            bw.write(" ")
        }
        for (k in 0 until n - i) {
            bw.write("*")
        }
        bw.newLine()
    }

    bw.close()
    br.close()
}