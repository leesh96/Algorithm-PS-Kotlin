package baekjoon.b19944

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = br.readLine().split(" ").map { it.toInt() }.run {
        val n = this[0]
        val m = this[1]
        when (m) {
            in 1..2 -> "NEWBIE!"
            in 3..n -> "OLDBIE!"
            else -> "TLE!"
        }
    }

    bw.write(answer)
    bw.close()
    br.close()
}