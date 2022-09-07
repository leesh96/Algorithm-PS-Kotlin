package baekjoon.b2455

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val riding = IntArray(4)
    val drop = IntArray(4)

    repeat(4) {
        StringTokenizer(br.readLine()).run {
            drop[it] = nextToken().toInt()
            riding[it] = nextToken().toInt()
        }
    }

    val total = IntArray(4)
    total[0] = riding[0] - drop[0]
    for (i in 1 until 4) {
        total[i] = total[i-1] + (riding[i] - drop[i])
    }
    val answer = total.maxOf { it }
    bw.write("$answer")
    bw.close()
    br.close()
}