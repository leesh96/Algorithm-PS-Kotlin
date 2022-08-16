package baekjoon.b17362

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()

    val answer = when {
        n % 8 == 0 -> 2
        n % 8 == 7 -> 3
        n % 8 == 6 -> 4
        else -> n % 8
    }

    bw.write("$answer")
    bw.close()
    br.close()
}