package baekjoon.b2010

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    var answer = 0
    repeat(n - 1) {
        answer += br.readLine().toInt() - 1
    }

    answer += br.readLine().toInt()

    bw.write("$answer")
    bw.close()
    br.close()
}