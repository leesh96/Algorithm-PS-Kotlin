package baekjoon.b10162

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var time = br.readLine().toInt()

    val a = time / 300
    time %= 300

    val b = time / 60
    time %= 60

    val c = time / 10
    time %= 10

    if (time != 0) {
        bw.write("-1")
    } else {
        bw.write("$a $b $c")
    }

    bw.flush()
    bw.close()
    br.close()
}