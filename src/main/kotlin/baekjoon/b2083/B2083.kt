package baekjoon.b2083

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    while (true) {
        val input = br.readLine()

        if (input == "# 0 0") break

        val answer = StringTokenizer(input).run {
            val name = nextToken()
            val age = nextToken().toInt()
            val weight = nextToken().toInt()
            "$name ${getPart(age, weight)}"
        }

        bw.write(answer)
        bw.newLine()
    }

    bw.close()
    br.close()
}

private fun getPart(age: Int, weight: Int): String = when {
    age > 17 || weight >= 80 -> "Senior"
    else -> "Junior"
}