package baekjoon.b11945

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val m: Int
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    repeat(n) {
        bw.write(br.readLine().reversed())
        bw.newLine()
    }

    bw.close()
    br.close()
}