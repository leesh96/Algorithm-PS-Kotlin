package baekjoon.b2440

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()

    for (i in n downTo 1) {
        for (j in 0 until i) {
            bw.write("*")
        }
        bw.newLine()
    }

    bw.close()
    br.close()
}