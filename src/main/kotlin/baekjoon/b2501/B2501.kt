package baekjoon.b2501

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = StringTokenizer(br.readLine()).run {
        val n = nextToken().toInt()
        val k = nextToken().toInt()

        var count = 0
        for (i in 1..n) {
            if (n % i == 0) {
                count++
            }

            if (count == k) {
                return@run i
            }
        }

        0
    }

    bw.write("$answer")
    bw.close()
    br.close()
}