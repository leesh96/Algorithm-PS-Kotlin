package baekjoon.b5532

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val l = br.readLine().toInt()
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    val d = br.readLine().toInt()

    val aDay = if (a % c == 0) a / c else a / c + 1
    val bDay = if (b % d == 0) b / d else b / d + 1

    val answer = l - maxOf(aDay, bDay)

    bw.write("$answer")
    bw.flush()
    bw.close()
    br.close()
}