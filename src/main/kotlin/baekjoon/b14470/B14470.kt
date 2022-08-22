package baekjoon.b14470

import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    val d = br.readLine().toInt()
    val e = br.readLine().toInt()

    val answer = when {
        a < 0 -> c * abs(a) + d + e * b
        a == 0 -> d + e * b
        else -> e * (b - a)
    }

    bw.write("$answer")
    bw.close()
    br.close()
}