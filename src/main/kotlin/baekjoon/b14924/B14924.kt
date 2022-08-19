package baekjoon.b14924

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = br.readLine().split(" ").map { it.toInt() }.run {
        val s = this[0]
        val t = this[1]
        val d = this[2]
        (d / (s * 2)) * t
    }

    bw.write("$answer")
    bw.close()
    br.close()
}