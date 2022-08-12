package baekjoon.b24883

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = br.readLine()

    if (a == "N" || a == "n") {
        bw.write("Naver D2")
    } else {
        bw.write("Naver Whale")
    }

    bw.close()
    br.close()
}