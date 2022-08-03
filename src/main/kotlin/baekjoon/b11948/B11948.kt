package baekjoon.b11948

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    val d = br.readLine().toInt()
    val e = br.readLine().toInt()
    val f = br.readLine().toInt()

    val answer = (a + b + c + d) - minOf(a, b, c, d) + maxOf(e, f)
    bw.write("$answer")
    bw.close()
    br.close()
}