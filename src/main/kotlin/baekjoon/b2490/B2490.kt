package baekjoon.b2490

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(3) {
        val result = br.readLine().split(" ").map { it.toInt() }.run {
            when (count { it == 0 }) {
                0 -> "E"
                1 -> "A"
                2 -> "B"
                3 -> "C"
                else -> "D"
            }
        }
        bw.write("$result\n")
    }
    bw.close()
    br.close()
}