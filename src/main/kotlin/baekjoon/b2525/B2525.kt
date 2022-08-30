package baekjoon.b2525

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a: Int
    val b: Int
    StringTokenizer(br.readLine()).run {
        a = nextToken().toInt()
        b = nextToken().toInt()
    }
    val c = br.readLine().toInt()

    val m = (b + c) % 60
    val h = ((b + c) / 60 + a) % 24

    bw.write("$h $m")
    bw.close()
    br.close()
}