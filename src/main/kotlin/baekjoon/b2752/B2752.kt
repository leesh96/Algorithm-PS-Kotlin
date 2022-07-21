package baekjoon.b2752

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = with(StringTokenizer(br.readLine())) {
        var sum = 0

        val a = nextToken().toInt()
        val b = nextToken().toInt()
        val c = nextToken().toInt()
        sum += a + b + c

        val max = maxOf(a, b, c)
        val min = minOf(a, b, c)

        "$min ${sum - max - min} $max"
    }

    bw.write(answer)
    bw.close()
    br.close()
}