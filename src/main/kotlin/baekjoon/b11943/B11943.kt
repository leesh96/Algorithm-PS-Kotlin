package baekjoon.b11943

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a: Int
    val b: Int
    StringTokenizer(br.readLine()).run {
        a = nextToken().toInt()
        b = nextToken().toInt()
    }

    val c: Int
    val d: Int
    StringTokenizer(br.readLine()).run {
        c = nextToken().toInt()
        d = nextToken().toInt()
    }

    val c1 = a + d
    val c2 = b + c
    bw.write("${minOf(c1, c2)}")
    bw.close()
    br.close()
}