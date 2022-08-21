package baekjoon.b14581

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine()

    repeat(3) {
        bw.write(":fan:")
    }
    bw.newLine()
    bw.write(":fan:")
    bw.write(":$n:")
    bw.write(":fan:")
    bw.newLine()
    repeat(3) {
        bw.write(":fan:")
    }
    bw.close()
    br.close()
}