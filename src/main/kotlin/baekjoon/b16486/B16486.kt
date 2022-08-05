package baekjoon.b16486

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val d1 = br.readLine().toInt()
    val d2 = br.readLine().toInt()

    val round = d2 * 2.0 * 3.141592
    val flat = d1 * 2
    val answer = flat + round
    bw.write(String.format("%.6f", answer))
    bw.close()
    br.close()
}