package baekjoon.b5596

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val s = br.readLine().split(" ").fold(0) { acc, s -> acc + s.toInt() }
    val p = br.readLine().split(" ").fold(0) { acc, s -> acc + s.toInt() }

    bw.write("${maxOf(s, p)}")
    bw.close()
    br.close()
}