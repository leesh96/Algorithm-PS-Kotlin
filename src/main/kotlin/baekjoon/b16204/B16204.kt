package baekjoon.b16204

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = StringTokenizer(br.readLine()).run {
        val n = nextToken().toInt()
        val m = nextToken().toInt()
        val k = nextToken().toInt()
        minOf(m, k) + minOf(n - m, n - k)
    }
    bw.write("$answer")
    bw.close()
    br.close()
}