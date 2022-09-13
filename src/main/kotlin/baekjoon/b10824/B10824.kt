package baekjoon.b10824

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val numbers = br.readLine().split(" ")
    val ab = "${numbers[0]}${numbers[1]}"
    val cd = "${numbers[2]}${numbers[3]}"
    val answer = ab.toLong() + cd.toLong()
    bw.write("$answer")
    bw.close()
    br.close()
}