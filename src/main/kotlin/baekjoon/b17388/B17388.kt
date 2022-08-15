package baekjoon.b17388

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = br.readLine().split(" ").map { it.toInt() }.run {
        val s = this[0]
        val k = this[1]
        val h = this[2]

        if (s + k + h >= 100) {
            "OK"
        } else {
            when (minOf(s, k, h)) {
                s -> "Soongsil"
                k -> "Korea"
                else -> "Hanyang"
            }
        }
    }

    bw.write(answer)
    bw.close()
    br.close()
}