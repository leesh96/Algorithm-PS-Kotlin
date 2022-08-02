package baekjoon.b1264

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val set = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    while (true) {
        val input = br.readLine()
        if (input == "#") {
            break
        }
        bw.write("${input.count { it in set }}")
        bw.newLine()
    }
    bw.close()
    br.close()
}