package baekjoon.b2530

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var h: Int
    var m: Int
    var s: Int
    with(StringTokenizer(br.readLine())) {
        h = nextToken().toInt()
        m = nextToken().toInt()
        s = nextToken().toInt()
    }

    val need = br.readLine().toInt()

    m += need / 60
    s += need % 60

    m += s / 60
    s %= 60

    h += m / 60
    m %= 60

    h %= 24

    bw.write("$h $m $s")
    bw.close()
    br.close()
}