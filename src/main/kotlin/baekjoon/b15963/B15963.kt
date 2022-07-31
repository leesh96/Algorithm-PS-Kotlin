package baekjoon.b15963

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Long
    val m: Long
    StringTokenizer(br.readLine()).run {
        n = nextToken().toLong()
        m = nextToken().toLong()
    }

    val answer = if (n == m) 1 else 0
    bw.write("$answer")
    bw.close()
    br.close()
}