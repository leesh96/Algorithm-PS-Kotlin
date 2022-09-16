package baekjoon.b2506

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val prob = br.readLine().split(" ").map { it.toInt() }

    var count = 0
    var score = 0
    for (i in 0 until n) {
        if (prob[i] == 1) {
            count += 1
            score += count
        } else {
            count = 0
        }
    }

    bw.write("$score")
    bw.close()
    br.close()
}