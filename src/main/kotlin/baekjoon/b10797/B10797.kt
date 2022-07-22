package baekjoon.b10797

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val arr = StringTokenizer(br.readLine()).run { IntArray(5) { nextToken().toInt() } }
    val answer = arr.count { it == n }

    bw.write("$answer")
    bw.close()
    br.close()
}