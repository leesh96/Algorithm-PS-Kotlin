package baekjoon.b15726

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val nums = br.readLine().split(" ").map { it.toDouble() }.toDoubleArray()
    val answer = maxOf((nums[0] * nums[1]) / nums[2], (nums[0] / nums[1]) * nums[2]).toInt()

    bw.write("$answer")
    bw.close()
    br.close()
}