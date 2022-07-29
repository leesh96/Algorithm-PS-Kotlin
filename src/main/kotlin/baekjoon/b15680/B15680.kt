package baekjoon.b15680

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val answer = br.readLine().toInt().run {
        if (this == 0) {
            "YONSEI"
        } else {
            "Leading the Way to the Future"
        }
    }

    bw.write(answer)
    bw.close()
    br.close()
}