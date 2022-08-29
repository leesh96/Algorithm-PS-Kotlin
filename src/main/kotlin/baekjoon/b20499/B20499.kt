package baekjoon.b20499

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = br.readLine().split("/").map { it.toInt() }.run {
        val k = this[0]
        val d = this[1]
        val a = this[2]

        if (k + a < d || d == 0) "hasu" else "gosu"
    }
    bw.write(answer)
    bw.close()
    br.close()
}