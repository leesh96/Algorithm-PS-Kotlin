package baekjoon.b5086

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    while (true) {
        val input = br.readLine()
        if (input == "0 0") break

        val answer = StringTokenizer(input).run {
            val first = nextToken().toInt()
            val second = nextToken().toInt()
            when {
                second % first == 0 -> "factor"
                first % second == 0 -> "multiple"
                else -> "neither"
            }
        }

        bw.write("$answer\n")
    }

    bw.close()
    br.close()
}