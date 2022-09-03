package baekjoon.b3009

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val xs = IntArray(3)
    val ys = IntArray(3)

    repeat(3) {
        StringTokenizer(br.readLine()).run {
            xs[it] = nextToken().toInt()
            ys[it] = nextToken().toInt()
        }
    }

    val x = when {
        xs[0] == xs[1] -> xs[2]
        xs[0] == xs[2] -> xs[1]
        else -> xs[0]
    }
    val y = when {
        ys[0] == ys[1] -> ys[2]
        ys[0] == ys[2] -> ys[1]
        else -> ys[0]
    }

    bw.write("$x $y")
    bw.close()
    br.close()
}