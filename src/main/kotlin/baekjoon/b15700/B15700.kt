package baekjoon.b15700

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = StringTokenizer(br.readLine()).run {
        val n = nextToken().toLong()
        val m = nextToken().toLong()
        (n * m) / 2
    }

    bw.write("$answer")
    bw.close()
    br.close()
}