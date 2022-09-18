package baekjoon.b2935

import java.math.BigInteger

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = BigInteger(br.readLine())
    val op = br.readLine()
    val b = BigInteger(br.readLine())

    val answer = if (op == "*") a.multiply(b) else a.add(b)

    bw.write("$answer")
    bw.close()
    br.close()
}