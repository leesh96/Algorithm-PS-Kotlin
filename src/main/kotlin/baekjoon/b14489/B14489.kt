package baekjoon.b14489

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a: Long
    val b: Long
    StringTokenizer(br.readLine()).run {
        a = nextToken().toLong()
        b = nextToken().toLong()
    }

    val c = br.readLine().toLong()
    val acc = a + b
    val answer = if (acc >= c * 2) acc - c * 2 else acc

    bw.write("$answer")
    bw.close()
    br.close()
}