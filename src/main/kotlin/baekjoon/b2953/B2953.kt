package baekjoon.b2953

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var chef = 1
    var max = Int.MIN_VALUE
    for (i in 1..5) {
        val score = br.readLine().split(" ").map { it.toInt() }.sumOf { it }

        if (max < score) {
            chef = i
            max = score
        }
    }

    bw.write("$chef $max")
    bw.close()
    br.close()
}