package baekjoon.b5063

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()

    repeat(n) {
        val answer = StringTokenizer(br.readLine()).run {
            val r = nextToken().toInt()
            val e = nextToken().toInt()
            val c = nextToken().toInt()
            val withAD = e - c
            when {
                r < withAD -> "advertise"
                r == withAD -> "does not matter"
                else -> "do not advertise"
            }
        }

        bw.write(answer)
        bw.newLine()
    }

    bw.close()
    br.close()
}