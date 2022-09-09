package baekjoon.b2576

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var sum = 0
    var min = Int.MAX_VALUE
    repeat(7) {
        val n = br.readLine().toInt()
        if (n % 2 != 0) {
            sum += n
            min = minOf(min, n)
        }
    }

    if (sum == 0) {
        bw.write("-1")
    } else {
        bw.write("$sum\n$min")
    }
    bw.close()
    br.close()
}