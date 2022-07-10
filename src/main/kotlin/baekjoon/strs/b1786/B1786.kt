package baekjoon.strs.b1786

/*
플랫폼 : 백준
문제번호 : 1786
문제제목 : 찾기
난이도 : 플래티넘 5
제한사항 : 2초/256MB
알고리즘 분류 : 문자열, kmp

알고리즘 설명
kmp 알고리즘

채점 결과 : 688ms/93480KB
풀이 날짜 : 2022/07/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private lateinit var answer: MutableList<Int>

fun main() {
    val t = br.readLine()
    val p = br.readLine()

    val table = preprocessing(p)
    answer = mutableListOf()
    kmp(t, p, table)

    bw.write("${answer.size}")
    bw.newLine()
    bw.write(answer.joinToString(" "))
    bw.close()
    br.close()
}

private fun preprocessing(pattern: String): IntArray {
    val m = pattern.length
    val ret = IntArray(m)

    var match = 0
    for (begin in 1 until m) {
        while (match > 0 && pattern[begin] != pattern[match]) {
            match = ret[match - 1]
        }

        if (pattern[begin] == pattern[match]) {
            match++
            ret[begin] = match
        }
    }

    return ret
}

private fun kmp(t: String, pattern: String, table: IntArray) {
    val n = t.length
    val m = pattern.length

    var j = 0
    for (i in 0 until n) {
        while (j > 0 && t[i] != pattern[j]) {
            j = table[j - 1]
        }

        if (t[i] == pattern[j]) {
            if (j == m - 1) {
                answer.add(i - m + 2)
                j = table[j]
            }
            else j++
        }
    }
}