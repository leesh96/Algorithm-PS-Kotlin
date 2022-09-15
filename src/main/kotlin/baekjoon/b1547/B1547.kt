package baekjoon.b1547

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var ball = 1
    val n = br.readLine().toInt()

    repeat(n) {
        StringTokenizer(br.readLine()).run {
            val x = nextToken().toInt()
            val y = nextToken().toInt()

            if (ball == x) {
                ball = y
            } else if (ball == y) {
                ball = x
            }
        }
    }

    bw.write("$ball")
    bw.close()
    br.close()
}