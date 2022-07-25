package baekjoon.b10156

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val k: Int
    val n: Int
    val m: Int
    with(StringTokenizer(br.readLine())) {
        k = nextToken().toInt()
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    val gap = (k * n) - m
    val answer = if (gap <= 0) 0 else gap

    bw.write("$answer")
    bw.close()
    br.close()
}