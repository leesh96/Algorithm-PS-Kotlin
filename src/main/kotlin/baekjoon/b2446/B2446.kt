package baekjoon.b2446

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()

    for (i in 0 until n) {
        for (j in 0 until i) {
            bw.write(" ")
        }
        for (k in 0 until (2 * n - 1) - (2 * i)) {
            bw.write("*")
        }
        bw.newLine()
    }

    for (i in 0 until n - 1) {
        for (j in 1 until n - i - 1) {
            bw.write(" ")
        }
        for (k in 0 until 3 + (2 * i)) {
            bw.write("*")
        }
        bw.newLine()
    }

    bw.close()
    br.close()
}