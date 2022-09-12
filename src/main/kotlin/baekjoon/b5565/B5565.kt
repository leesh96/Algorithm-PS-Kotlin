private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val sum = br.readLine().toInt()
    val prices = IntArray(9) { br.readLine().toInt() }
    val sumOf = prices.sum()
    
    bw.write("${sum - sumOf}")
    bw.close()
    br.close()
}
