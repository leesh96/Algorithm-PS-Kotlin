package baekjoon.b5543

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val burger = IntArray(3) { br.readLine().toInt() }
    val drink = IntArray(2) { br.readLine().toInt() }

    val answer = burger.minOf { it } + drink.minOf { it } - 50
    bw.write("$answer")
    bw.close()
    br.close()
}