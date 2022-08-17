package baekjoon.b4299

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val sum: Int
    val diff: Int
    with(StringTokenizer(br.readLine())) {
        sum = nextToken().toInt()
        diff = nextToken().toInt()
    }

    val answer = if (sum < diff) {
        "-1"
    } else {
        val x = (sum + diff) / 2
        val y = (sum - diff) / 2
        if (x + y == sum && x - y == diff) {
            "$x $y"
        } else {
            "-1"
        }
    }

    bw.write(answer)
    bw.close()
    br.close()
}