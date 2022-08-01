package baekjoon.b10768

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val month = br.readLine().toInt()
    val day = br.readLine().toInt()

    val answer = when {
        month < 2 -> "Before"
        month == 2 && day < 18 -> "Before"
        month == 2 && day == 18 -> "Special"
        else -> "After"
    }

    bw.write(answer)
    bw.close()
    br.close()
}