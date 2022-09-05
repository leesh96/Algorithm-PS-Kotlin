package baekjoon.b3053

import kotlin.math.PI

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val r = br.readLine().toDouble()
    val euclid = r * r * PI
    val taxi = r * r * 2

    bw.write("$euclid\n$taxi")
    bw.close()
    br.close()
}