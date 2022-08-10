package baekjoon.b19698

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = br.readLine().split(" ").map { it.toInt() }.run {
        val w = this[1] / this[3]
        val h = this[2] / this[3]

        minOf(w * h, this[0])
    }

    bw.write("$answer")
    bw.close()
    br.close()
}