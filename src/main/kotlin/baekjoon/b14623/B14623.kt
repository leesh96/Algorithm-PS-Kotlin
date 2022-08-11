package baekjoon.b14623

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = br.readLine()
    val b = br.readLine()

    val al = a.toLong(2)
    val bl = b.toLong(2)

    val answer = (al * bl).toString(2)

    bw.write(answer)
    bw.close()
    br.close()
}