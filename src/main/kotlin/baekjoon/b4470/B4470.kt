package baekjoon.b4470

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    repeat(n) {
        val input = br.readLine()
        bw.write("${it+1}. $input")
        bw.newLine()
    }
    bw.close()
    br.close()
}