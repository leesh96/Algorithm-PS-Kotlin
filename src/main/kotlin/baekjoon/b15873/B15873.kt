package baekjoon.b15873

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = br.readLine()

    val answer = when (input.length) {
        4 -> 20
        3 -> {
            if (input[1] == '0') {
                10 + input[2].digitToInt()
            } else {
                10 + input[0].digitToInt()
            }
        }
        else -> input[0].digitToInt() + input[1].digitToInt()
    }

    bw.write("$answer")
    bw.close()
    br.close()
}