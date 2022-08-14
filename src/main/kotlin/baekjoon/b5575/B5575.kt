package baekjoon.b5575

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(3) {
        val answer = br.readLine().split(" ").map { it.toInt() }.run {
            val start = this[0] * 3600 + this[1] * 60 + this[2]
            val end = this[3] * 3600 + this[4] * 60 + this[5]
            val secGap = end - start
            "${secGap / 3600} ${(secGap % 3600) / 60} ${(secGap % 3600) % 60}"
        }
        bw.write("$answer\n")
    }
    bw.close()
    br.close()
}