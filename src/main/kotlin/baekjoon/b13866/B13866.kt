package baekjoon.b13866

import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = br.readLine().split(" ").map { it.toInt() }.sorted().run {
        abs((this[0] + this[3]) - (this[1] + this[2]))
    }

    bw.write("$answer")
    bw.close()
    br.close()
}